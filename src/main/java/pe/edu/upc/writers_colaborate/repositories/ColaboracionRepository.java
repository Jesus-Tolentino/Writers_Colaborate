package pe.edu.upc.writers_colaborate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.writers_colaborate.entities.Colaboracion;

import java.util.List;

public interface ColaboracionRepository extends JpaRepository<Colaboracion, Long> {

    public List<Colaboracion> findByAutor_Id(Long id);

    public List<Colaboracion> findByCapitulo_Id(Long id);
}
