package pe.edu.upc.writers_colaborate.services;

import pe.edu.upc.writers_colaborate.dtos.ComentarioDTO;
import pe.edu.upc.writers_colaborate.entities.Comentario;

import java.util.List;

public interface ComentarioService {

    public ComentarioDTO add(ComentarioDTO comentarioDTO);

    public Comentario edit(Comentario comentario);

    public void delete(Long id);

    public Comentario findById(Long id);

    public List<Comentario> listAll();

    public List<Comentario> listByAutorId(Long id);

    public List<Comentario> listByProyectoId(Long id);
}
