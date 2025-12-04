package pe.edu.upc.writers_colaborate.services;

import pe.edu.upc.writers_colaborate.dtos.ProyectoGeneroDTO;
import pe.edu.upc.writers_colaborate.entities.ProyectoGenero;

import java.util.List;

public interface ProyectoGeneroService {

    public ProyectoGeneroDTO add(ProyectoGeneroDTO proyectoGeneroDTO);

    public ProyectoGenero edit(ProyectoGenero proyectoGenero);

    public void delete(Long id);

    public ProyectoGenero findById(Long id);

    public List<ProyectoGenero> listAll();

    public List<ProyectoGenero> listByProyectoId(Long id);

    public List<ProyectoGenero> listByGeneroId(Long id);
}
