package pe.edu.upc.writers_colaborate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.writers_colaborate.entities.Proyecto;

import java.util.List;

public interface ProyectoRepository extends JpaRepository<Proyecto,Long> {

    public List<Proyecto> findByAutor_Id(Long id);
}
