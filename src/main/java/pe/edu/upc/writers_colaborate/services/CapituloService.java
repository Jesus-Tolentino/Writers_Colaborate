package pe.edu.upc.writers_colaborate.services;

import pe.edu.upc.writers_colaborate.dtos.CapituloDTO;
import pe.edu.upc.writers_colaborate.entities.Capitulo;

import java.util.List;

public interface CapituloService {

    public CapituloDTO add(CapituloDTO capituloDTO);

    public Capitulo edit(Capitulo capitulo);

    public void delete(Long id);

    public Capitulo findById(Long id);

    public List<Capitulo> listAll();

    public List<Capitulo> listByProyectoId(Long id);
}
