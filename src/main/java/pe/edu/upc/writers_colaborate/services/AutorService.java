package pe.edu.upc.writers_colaborate.services;

import pe.edu.upc.writers_colaborate.entities.Autor;

import java.util.List;

public interface AutorService {

    public Autor add(Autor autor);

    public Autor edit(Autor autor);

    public void delete(Long id);

    public Autor findById(Long id);

    public List<Autor> listAll();
}
