package pe.edu.upc.writers_colaborate.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.writers_colaborate.dtos.CapituloDTO;
import pe.edu.upc.writers_colaborate.entities.Capitulo;
import pe.edu.upc.writers_colaborate.entities.Proyecto;
import pe.edu.upc.writers_colaborate.repositories.CapituloRepository;
import pe.edu.upc.writers_colaborate.services.CapituloService;
import pe.edu.upc.writers_colaborate.services.ProyectoService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CapituloServiceImpl implements CapituloService {

    @Autowired
    public CapituloRepository capituloRepository;

    @Autowired
    public ProyectoService proyectoService;

    @Override
    public CapituloDTO add(CapituloDTO capituloDTO) {
        /*
        1. Validar de los campos cumplan los requisitos
        2. Grabar la carrera en la BD
        */

        Proyecto proyectoFound = proyectoService.findById(capituloDTO.getProyectoId());
        if (proyectoFound==null) {
            return null;
        }
        if (capituloDTO.getTitle()==null || capituloDTO.getTitle().isBlank()) {
            return null;
        }
        if (capituloDTO.getContent()==null || capituloDTO.getContent().isBlank()) {
            return null;
        }
        if (capituloDTO.getChapterNumber()==null) {
            return null;
        }
        if (capituloDTO.getCreationDate()==null) {
            return null;
        }
        if (capituloDTO.getPublished()==null) {
            return null;
        }

        Object List;
        Capitulo capitulo = new Capitulo(null, capituloDTO.getTitle(), capituloDTO.getContent(),
                capituloDTO.getChapterNumber(), capituloDTO.getCreationDate(), capituloDTO.getPublished(), proyectoFound, new ArrayList<>());
        capitulo = capituloRepository.save(capitulo);

        capituloDTO.setId(capitulo.getId());
        return capituloDTO;
    }

    @Override
    public Capitulo edit(Capitulo capitulo) {
        return null;
    }

    @Override
    public void delete(Long id) {
        Capitulo capituloFound = findById(id);
        if (capituloFound==null){
            return;
        }
        capituloRepository.deleteById(id);
    }

    @Override
    public Capitulo findById(Long id) {
        return capituloRepository.findById(id).orElse(null);
    }

    @Override
    public List<Capitulo> listAll() {
        return capituloRepository.findAll();
    }

    @Override
    public List<Capitulo> listByProyectoId(Long id) {
        return capituloRepository.findByProyecto_Id(id);
    }
}
