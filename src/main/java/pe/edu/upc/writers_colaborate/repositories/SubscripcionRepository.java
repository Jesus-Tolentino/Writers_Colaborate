package pe.edu.upc.writers_colaborate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.writers_colaborate.entities.Subscripcion;

import java.util.List;

public interface SubscripcionRepository extends JpaRepository<Subscripcion,Long> {

    public List<Subscripcion> findByAutor_Id(Long id);
}
