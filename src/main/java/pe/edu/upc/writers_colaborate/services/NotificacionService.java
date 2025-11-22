package pe.edu.upc.writers_colaborate.services;

import pe.edu.upc.writers_colaborate.dtos.NotificacionDTO;
import pe.edu.upc.writers_colaborate.entities.Notificacion;

import java.util.List;

public interface NotificacionService {

    public NotificacionDTO add(NotificacionDTO notificacionDTO);

    public Notificacion edit(Notificacion notificacion);

    public void delete(Long id);

    public Notificacion findById(Long id);

    public List<Notificacion> listAll();

    public List<Notificacion> listByProyectoId(Long id);
}
