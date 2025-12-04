package pe.edu.upc.writers_colaborate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.writers_colaborate.entities.Notificacion;

import java.util.List;

public interface NotificacionRepository extends JpaRepository<Notificacion,Long> {

    public List<Notificacion> findByProyecto_Id(Long id);
}
