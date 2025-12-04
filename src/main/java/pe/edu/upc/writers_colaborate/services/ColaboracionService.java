package pe.edu.upc.writers_colaborate.services;

import pe.edu.upc.writers_colaborate.dtos.ColaboracionDTO;
import pe.edu.upc.writers_colaborate.entities.Colaboracion;

import java.util.List;

public interface ColaboracionService {

    public ColaboracionDTO add(ColaboracionDTO colaboracionDTO);

    public Colaboracion edit(Colaboracion colaboracion);

    public void delete(Long id);

    public Colaboracion findById(Long id);

    public List<Colaboracion> listAll();

    public List<Colaboracion> listByAutorId(Long id);

    public List<Colaboracion> listByCapituloId(Long id);
}
