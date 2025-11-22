package pe.edu.upc.writers_colaborate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.writers_colaborate.entities.Reunion;

import java.util.List;

public interface ReunionRepository extends JpaRepository<Reunion, Long> {

    public List<Reunion> findByProyecto_Id(Long id);
}
