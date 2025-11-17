package pe.edu.upc.writers_colaborate.services;

import pe.edu.upc.writers_colaborate.dtos.ColeccionProyectoDTO;
import pe.edu.upc.writers_colaborate.entities.ColeccionProyecto;

import java.util.List;

public interface ColeccionProyectoService {

    public ColeccionProyectoDTO add(ColeccionProyectoDTO coleccionProyectoDTO);

    public ColeccionProyecto edit(ColeccionProyecto coleccionProyecto);

    public void delete(Long id);

    public ColeccionProyecto findById(Long id);

    public List<ColeccionProyecto> listAll();

    public List<ColeccionProyecto> listByColeccionId(Long id);

    public List<ColeccionProyecto> listByProyectoId(Long id);
}
