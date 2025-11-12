package net.ausiasmarch.persutil.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.ausiasmarch.persutil.entity.BlogEntity;
import net.ausiasmarch.persutil.service.AleatorioService;
import net.ausiasmarch.persutil.service.BlogService;

@RestController //con esto le decimos que es un controlador de tipo REST
@RequestMapping("/blog") //con esto le decimos la ruta inicial de este controlador
public class BlogApi {

    //inyectamos el servicio de aleatorio
    @Autowired
    AleatorioService oAleatorioService;

    @Autowired
    BlogService oBlogService;

    @GetMapping("/saludar")
    public ResponseEntity<String> saludar() {
        return new ResponseEntity<>("\"¡Hola, Blog!\"", HttpStatus.OK);
    }

    @GetMapping("/aleatorio") //endpoint
    public ResponseEntity<Integer> aleatorio() {
        int numeroAleatorio = (int) (Math.random() * 100) + 1; // Genera un número aleatorio entre 1 y 100
        return ResponseEntity.ok(numeroAleatorio);
    }

    @GetMapping("/aleatorio/{min}/{max}") //endpoint
    public ResponseEntity<Integer> aleatorioEnRango(@PathVariable int min,
            @PathVariable int max) {
        int numeroAleatorio = (int) (Math.random() * (max - min + 1)) + min; // Genera un número aleatorio entre min y max
        return ResponseEntity.ok(numeroAleatorio);
    }

    @GetMapping("/aleatorio/service/{min}/{max}") //endpoint
    public ResponseEntity<Integer> aleatorioUsandoServiceEnRango(@PathVariable int min,
            @PathVariable int max) {
        return ResponseEntity.ok(oAleatorioService.generarNumeroAleatorioEnteroEnRango(min, max));
    }

    @GetMapping("/rellenauno")
    public ResponseEntity<Long> rellenarBlog() {
        return ResponseEntity.ok(oBlogService.rellenarBlog());
    }

    // obtener un blog por id y mostrarlo en formato JSON
    @GetMapping("/{id}")
    public ResponseEntity<BlogEntity> get(@PathVariable Long id) {
        return ResponseEntity.ok(oBlogService.get(id));
    }
}
