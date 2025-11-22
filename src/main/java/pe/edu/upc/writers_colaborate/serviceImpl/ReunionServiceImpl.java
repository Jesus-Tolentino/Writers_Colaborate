package pe.edu.upc.writers_colaborate.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.writers_colaborate.dtos.ReunionDTO;
import pe.edu.upc.writers_colaborate.entities.Proyecto;
import pe.edu.upc.writers_colaborate.entities.Reunion;
import pe.edu.upc.writers_colaborate.repositories.ReunionRepository;
import pe.edu.upc.writers_colaborate.services.ProyectoService;
import pe.edu.upc.writers_colaborate.services.ReunionService;

import java.util.List;

@Service
public class ReunionServiceImpl implements ReunionService {

    @Autowired
    public ReunionRepository reunionRepository;

    @Autowired
    public ProyectoService proyectoService;

    @Override
    public ReunionDTO add(ReunionDTO reunionDTO) {
        /*
        1. Validar de los campos cumplan los requisitos
        2. Grabar la carrera en la BD
        */

        Proyecto proyectoFound = proyectoService.findById(reunionDTO.getProyectoId());
        if (proyectoFound==null) {
            return null;
        }
        if (reunionDTO.getIssue()==null || reunionDTO.getIssue().isBlank()) {
            return null;
        }
        if (reunionDTO.getDescription()==null || reunionDTO.getDescription().isBlank()) {
            return null;
        }
        if (reunionDTO.getMeetingDate()==null) {
            return null;
        }
        if (reunionDTO.getStartHour()==null) {
            return null;
        }
        if (reunionDTO.getEndHour()==null) {
            return null;
        }
        if (reunionDTO.getLink()==null || reunionDTO.getLink().isBlank()) {
            return null;
        }

        Reunion reunion = new Reunion(null, reunionDTO.getIssue(), reunionDTO.getDescription(),
                reunionDTO.getMeetingDate(), reunionDTO.getStartHour(), reunionDTO.getEndHour(), reunionDTO.getLink(), proyectoFound);
        reunion = reunionRepository.save(reunion);

        reunionDTO.setId(reunion.getId());
        return reunionDTO;
    }

    @Override
    public Reunion edit(Reunion reunion) {
        return null;
    }

    @Override
    public void delete(Long id) {
        Reunion reunionFound = findById(id);
        if (reunionFound==null){
            return;
        }
        reunionRepository.deleteById(id);
    }

    @Override
    public Reunion findById(Long id) {
        return reunionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Reunion> listAll() {
        return reunionRepository.findAll();
    }

    @Override
    public List<Reunion> listByProyectoId(Long id) {
        return reunionRepository.findByProyecto_Id(id);
    }
}
