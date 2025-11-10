package net.ausiasmarch.persutil.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController //con esto le decimos que es un controlador de tipo REST
@RequestMapping("/blog") //con esto le decimos la ruta inicial de este controlador
public class BlogApi {
    
    @GetMapping("/saludar")
    public ResponseEntity<String> saludar() {
        return new ResponseEntity<>("¡Hola, Blog!", HttpStatus.OK);
    }

}
