package pe.edu.upc.writers_colaborate.services;

import pe.edu.upc.writers_colaborate.entities.Genero;

import java.util.List;

public interface GeneroService {

    public Genero add(Genero genero);

    public Genero edit(Genero genero);

    public void delete(Long id);

    public Genero findById(Long id);

    public List<Genero> listAll();
}
