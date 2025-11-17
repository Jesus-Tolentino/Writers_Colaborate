package pe.edu.upc.writers_colaborate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.writers_colaborate.entities.Coleccion;

import java.time.LocalDate;
import java.util.List;

public interface ColeccionRepository extends JpaRepository<Coleccion,Long> {

    List<Coleccion> findByTitle(String title);

    List<Coleccion> findByCreationDate(LocalDate creationDate);
}
