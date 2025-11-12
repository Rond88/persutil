package net.ausiasmarch.persutil.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ausiasmarch.persutil.entity.BlogEntity;
import net.ausiasmarch.persutil.repository.BlogRepository;

@Service
public class BlogService {
    public final static int NUM_PALABRAS = 5;

    @Autowired
    BlogRepository oBlogRepository;

    public Long rellenarBlog() {
        // array de palabras
        ArrayList<String> palabras = new ArrayList<>(Arrays.asList(
                "sol", "luna", "estrellas", "planeta", "galaxia",
                "arbol", "flor", "rio", "montaña", "nube",
                "casa", "coche", "libro", "ordenador", "telefono",
                "musica", "arte", "historia", "ciencia", "deporte",
                "familia", "amigo", "trabajo", "escuela", "comida",
                "viaje", "tiempo", "agua", "fuego", "tierra",
                "alegria", "paz", "esperanza", "silencio", "sueño"
        ));
        

        // Lógica para rellenar el blog
        BlogEntity oBlogEntity = new BlogEntity();
        oBlogEntity.setTitulo("Mi primer blog");
        oBlogEntity.setContenido(crearContenidoAleatorio(palabras));
        oBlogEntity.setEtiquetas("etiqueta1, etiqueta2");
        oBlogEntity.setFechaCreacion(LocalDateTime.now());
        oBlogEntity.setFechaModificacion(null);

        oBlogRepository.save(oBlogEntity);
    
        return oBlogRepository.count();
    }
    // contenido de cinco palabras aleatorias
    public String crearContenidoAleatorio(List<String> palabras) {
        StringBuilder contenido = new StringBuilder();
        for (int i = 0; i < NUM_PALABRAS; i++) {
            int indiceAleatorio = (int) (Math.random() * palabras.size());
            contenido.append(palabras.get(indiceAleatorio)).append(" ");
        }
        return contenido.toString();
    }

    public BlogEntity get(Long id) {
        return oBlogRepository.findById(id).orElseThrow(() -> new RuntimeException("Blog not found"));
    }
}
