package pe.edu.upc.writers_colaborate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.writers_colaborate.entities.Capitulo;

import java.util.List;

public interface CapituloRepository extends JpaRepository<Capitulo, Long> {

    public List<Capitulo> findByProyecto_Id(Long id);
}
