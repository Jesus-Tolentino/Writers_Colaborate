package pe.edu.upc.writers_colaborate.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.writers_colaborate.dtos.NotificacionDTO;
import pe.edu.upc.writers_colaborate.entities.Notificacion;
import pe.edu.upc.writers_colaborate.entities.Proyecto;
import pe.edu.upc.writers_colaborate.repositories.NotificacionRepository;
import pe.edu.upc.writers_colaborate.services.NotificacionService;
import pe.edu.upc.writers_colaborate.services.ProyectoService;

import java.util.List;

@Service
public class NotificacionServiceImpl implements NotificacionService {

    @Autowired
    public NotificacionRepository notificacionRepository;

    @Autowired
    public ProyectoService proyectoService;

    @Override
    public NotificacionDTO add(NotificacionDTO notificacionDTO) {
        /*
        1. Validar de los campos cumplan los requisitos
        2. Grabar la carrera en la BD
        */

        Proyecto proyectoFound = proyectoService.findById(notificacionDTO.getProyectoId());
        if (proyectoFound==null) {
            return null;
        }
        if (notificacionDTO.getMessage()==null || notificacionDTO.getMessage().isBlank()) {
            return null;
        }
        if (notificacionDTO.getCreationDate()==null) {
            return null;
        }
        if (notificacionDTO.getState()==null) {
            return null;
        }

        Notificacion notificacion = new Notificacion(null, notificacionDTO.getMessage(), notificacionDTO.getCreationDate(),
                notificacionDTO.getState(), proyectoFound);
        notificacion = notificacionRepository.save(notificacion);

        notificacionDTO.setId(notificacion.getId());
        return notificacionDTO;
    }

    @Override
    public Notificacion edit(Notificacion notificacion) {
        return null;
    }

    @Override
    public void delete(Long id) {
        Notificacion notificacionFound = findById(id);
        if (notificacionFound==null){
            return;
        }
        notificacionRepository.deleteById(id);
    }

    @Override
    public Notificacion findById(Long id) {
        return notificacionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Notificacion> listAll() {
        return notificacionRepository.findAll();
    }

    @Override
    public List<Notificacion> listByProyectoId(Long id) {
        return notificacionRepository.findByProyecto_Id(id);
    }

}
