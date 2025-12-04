package pe.edu.upc.writers_colaborate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.writers_colaborate.entities.Comentario;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario,Long> {

    public List<Comentario> findByAutor_Id(Long id);

    public List<Comentario> findByProyecto_Id(Long id);
}
