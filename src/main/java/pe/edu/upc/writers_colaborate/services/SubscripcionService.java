package pe.edu.upc.writers_colaborate.services;

import pe.edu.upc.writers_colaborate.dtos.SubscripcionDTO;
import pe.edu.upc.writers_colaborate.entities.Subscripcion;

import java.util.List;

public interface SubscripcionService {

    public SubscripcionDTO add(SubscripcionDTO subscripcionDTO);

    public Subscripcion edit(Subscripcion subscripcion);

    public void delete(Long id);

    public Subscripcion findById(Long id);

    public List<Subscripcion> listAll();

    public List<Subscripcion> listByAutorId(Long id);
}
