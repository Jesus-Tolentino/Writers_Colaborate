package pe.edu.upc.writers_colaborate.services;

import pe.edu.upc.writers_colaborate.dtos.ReunionDTO;
import pe.edu.upc.writers_colaborate.entities.Reunion;

import java.util.List;

public interface ReunionService {

    public ReunionDTO add(ReunionDTO reunionDTO);

    public Reunion edit(Reunion reunion);

    public void delete(Long id);

    public Reunion findById(Long id);

    public List<Reunion> listAll();

    public List<Reunion> listByProyectoId(Long id);
}
