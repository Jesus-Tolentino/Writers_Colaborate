package pe.edu.upc.writers_colaborate.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.writers_colaborate.dtos.ProyectoDTO;
import pe.edu.upc.writers_colaborate.entities.Autor;
import pe.edu.upc.writers_colaborate.entities.Proyecto;
import pe.edu.upc.writers_colaborate.repositories.ProyectoRepository;
import pe.edu.upc.writers_colaborate.services.AutorService;
import pe.edu.upc.writers_colaborate.services.ProyectoService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProyectoServiceImpl implements ProyectoService {

    @Autowired
    public ProyectoRepository proyectoRepository;

    @Autowired
    public AutorService autorService;


    @Override
    public ProyectoDTO add(ProyectoDTO proyectoDTO) {
        /*
        1. Validar de los campos cumplan los requisitos
        2. Grabar la carrera en la BD
        */

        Autor autorFound = autorService.findById(proyectoDTO.getAutorId());
        if (autorFound==null) {
            return null;
        }
        if (proyectoDTO.getTitle()==null || proyectoDTO.getTitle().isBlank()) {
            return null;
        }
        if (proyectoDTO.getDescription()==null || proyectoDTO.getDescription().isBlank()) {
            return null;
        }
        if (proyectoDTO.getCreationDate()==null) {
            return null;
        }
        if (proyectoDTO.getPublicationDate()==null) {
            return null;
        }
        if (proyectoDTO.getState()==null || proyectoDTO.getState().isBlank()) {
            return null;
        }
        if (proyectoDTO.getMeetingsEnabled()==null) {
            return null;
        }

        Proyecto proyecto = new Proyecto(null, proyectoDTO.getTitle(), proyectoDTO.getDescription(),
                proyectoDTO.getCreationDate(), proyectoDTO.getPublicationDate(), proyectoDTO.getState(), proyectoDTO.getMeetingsEnabled(), autorFound,
                new ArrayList<>(),new ArrayList<>(),new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        proyecto = proyectoRepository.save(proyecto);

        proyectoDTO.setId(proyecto.getId());
        return proyectoDTO;
    }

    @Override
    public Proyecto edit(Proyecto proyecto) {
    Proyecto proyectoFound= findById(proyecto.getId());
        if (proyectoFound==null){
            return null;
        }
        if(proyecto.getTitle()!=null && !proyecto.getTitle().isBlank()) {
            proyectoFound.setTitle(proyecto.getTitle());

        }
        if(proyecto.getDescription()!=null && !proyecto.getDescription().isBlank()) {
            proyectoFound.setDescription(proyecto.getDescription());
        }
        if(proyecto.getCreationDate()!=null) {
            proyectoFound.setCreationDate(proyecto.getCreationDate());
        }
        if(proyecto.getPublicationDate()!=null) {
            proyectoFound.setPublicationDate(proyecto.getPublicationDate());
        }
        if(proyecto.getState()!=null && !proyecto.getState().isBlank()) {
            proyectoFound.setState(proyecto.getState());

        }

        proyectoFound.setMeetingsEnabled(proyecto.isMeetingsEnabled());

        return proyectoRepository.save(proyectoFound);
    }

    @Override
    public void delete(Long id) {
        Proyecto proyectoFound = findById(id);
        if (proyectoFound==null){
            return;
        }
        proyectoRepository.deleteById(id);
    }

    @Override
    public Proyecto findById(Long id) {
        return proyectoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Proyecto> listAll() {
        return proyectoRepository.findAll();
    }

    @Override
    public List<Proyecto> listByAutorId(Long id) {
        return proyectoRepository.findByAutor_Id(id);
    }
}
