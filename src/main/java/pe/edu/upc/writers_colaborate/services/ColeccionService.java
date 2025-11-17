package pe.edu.upc.writers_colaborate.services;

import pe.edu.upc.writers_colaborate.entities.Coleccion;

import java.util.List;

public interface ColeccionService {

    public Coleccion add(Coleccion coleccion);

    public Coleccion edit(Coleccion coleccion);

    public void delete(Long id);

    public Coleccion findById(Long id);

    public List<Coleccion> listAll();
}
