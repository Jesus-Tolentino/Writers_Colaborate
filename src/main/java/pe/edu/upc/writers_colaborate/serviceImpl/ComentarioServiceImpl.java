package pe.edu.upc.writers_colaborate.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.writers_colaborate.dtos.ComentarioDTO;
import pe.edu.upc.writers_colaborate.entities.Autor;
import pe.edu.upc.writers_colaborate.entities.Comentario;
import pe.edu.upc.writers_colaborate.entities.Proyecto;
import pe.edu.upc.writers_colaborate.repositories.ComentarioRepository;
import pe.edu.upc.writers_colaborate.services.AutorService;
import pe.edu.upc.writers_colaborate.services.ComentarioService;
import pe.edu.upc.writers_colaborate.services.ProyectoService;

import java.util.List;

@Service
public class ComentarioServiceImpl implements ComentarioService {

    @Autowired
    public ComentarioRepository comentarioRepository;

    @Autowired
    public AutorService autorService;

    @Autowired
    public ProyectoService proyectoService;

    @Override
    public ComentarioDTO add(ComentarioDTO comentarioDTO) {
        /*
        1. Validar de los campos cumplan los requisitos
        2. Grabar la carrera en la BD
        */

        Autor autorFound = autorService.findById(comentarioDTO.getAutorId());
        if (autorFound == null) {
            return null;
        }
        Proyecto proyectoFound = proyectoService.findById(comentarioDTO.getProyectoId());
        if (proyectoFound == null) {
            return null;
        }
        if (comentarioDTO.getContent() == null || comentarioDTO.getContent().isBlank()) {
            return null;
        }
        if (comentarioDTO.getPublicationDate() == null) {
            return null;
        }

        Comentario comentario = new Comentario(null, comentarioDTO.getContent(), comentarioDTO.getPublicationDate(), autorFound, proyectoFound);
        comentario = comentarioRepository.save(comentario);

        comentarioDTO.setId(comentario.getId());
        return comentarioDTO;
    }

    @Override
    public Comentario edit(Comentario comentario) {
        return null;
    }

    @Override
    public void delete(Long id) {
        Comentario comentarioFound = findById(id);
        if (comentarioFound == null) {
            return;
        }
        comentarioRepository.deleteById(id);
    }

    @Override
    public Comentario findById(Long id) {
        return comentarioRepository.findById(id).orElse(null);
    }

    @Override
    public List<Comentario> listAll() {
        return comentarioRepository.findAll();
    }

    @Override
    public List<Comentario> listByAutorId(Long id) {
        return comentarioRepository.findByAutor_Id(id);
    }

    @Override
    public List<Comentario> listByProyectoId(Long id) {
        return comentarioRepository.findByProyecto_Id(id);
    }
}
