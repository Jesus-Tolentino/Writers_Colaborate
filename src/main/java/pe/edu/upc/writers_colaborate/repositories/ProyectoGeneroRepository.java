package pe.edu.upc.writers_colaborate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.writers_colaborate.entities.ProyectoGenero;

import java.util.List;

public interface ProyectoGeneroRepository extends JpaRepository<ProyectoGenero, Long> {

    public List<ProyectoGenero> findByProyecto_Id(Long id);

    public List<ProyectoGenero> findByGenero_Id(Long id);
}
