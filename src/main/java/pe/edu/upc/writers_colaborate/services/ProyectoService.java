package pe.edu.upc.writers_colaborate.services;

import pe.edu.upc.writers_colaborate.dtos.ProyectoDTO;
import pe.edu.upc.writers_colaborate.entities.Proyecto;

import java.util.List;

public interface ProyectoService {

    public ProyectoDTO add(ProyectoDTO proyectoDTO);

    public Proyecto edit(Proyecto proyecto);

    public void delete(Long id);

    public Proyecto findById(Long id);

    public List<Proyecto> listAll();

    public List<Proyecto> listByAutorId(Long id);
}
