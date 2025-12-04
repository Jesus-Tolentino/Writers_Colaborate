package pe.edu.upc.writers_colaborate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.writers_colaborate.entities.Genero;

import java.util.List;

public interface GeneroRepository extends JpaRepository<Genero, Long> {

    List<Genero> findByName(String name);

}
