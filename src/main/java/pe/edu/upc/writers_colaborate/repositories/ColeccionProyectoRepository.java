package pe.edu.upc.writers_colaborate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.writers_colaborate.entities.ColeccionProyecto;

import java.util.List;

public interface ColeccionProyectoRepository extends JpaRepository<ColeccionProyecto,Long> {

    public List<ColeccionProyecto> findByColeccion_Id(Long id);

    public List<ColeccionProyecto> findByProyecto_Id(Long id);
}
