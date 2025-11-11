package net.ausiasmarch.persutil.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ausiasmarch.persutil.entity.BlogEntity;
import net.ausiasmarch.persutil.repository.BlogRepository;

@Service
public class BlogService {

    @Autowired
    BlogRepository oBlogRepository;
    public Long  rellenarBlog() {
        // crear un arrayList con 25 palabras aleatorias
        
        // Lógica para rellenar el blog
        BlogEntity oBlogEntity = new BlogEntity();
        oBlogEntity.setTitulo("Mi primer blog");
        oBlogEntity.setContenido("Este es el contenido de mi primer blog.");
        oBlogEntity.setEtiquetas("etiqueta1, etiqueta2");
        oBlogEntity.setFechaCreacion(LocalDateTime.now());
        oBlogEntity.setFechaModificacion(null);

        oBlogRepository.save(oBlogEntity);

        return oBlogRepository.count();
    }
}
