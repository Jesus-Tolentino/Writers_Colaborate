package pe.edu.upc.writers_colaborate.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.writers_colaborate.entities.Autor;
import pe.edu.upc.writers_colaborate.repositories.AutorRepository;
import pe.edu.upc.writers_colaborate.services.AutorService;

import java.util.List;

@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    AutorRepository autorRepository;

    public boolean validarEntidad(Autor autor){
        if (autor.getName()==null || autor.getName().isBlank()) {
            return false;
        }
        if (autor.getLastName()==null || autor.getLastName().isBlank()) {
            return false;
        }
        if (autor.getBirthdate()==null) {
            return false;
        }
        if (autor.getEmail()==null || autor.getEmail().isBlank()) {
            return false;
        }
        return true;
    }

    @Override
    public Autor add(Autor autor) {
        /*
        1. Validar que los campos cumplan los requisitos
        2. Grabar al autor en la BD
        */
        if (!validarEntidad(autor)) {
            return null;
        }
        //Validar si el nombre ya esta registrado
        if (!autorRepository.findByName(autor.getName()).isEmpty()) {
            //System.out.println(facultyRepository.findByName(faculty.getName()));
            return null;
        }
        if (!autorRepository.findByLastName(autor.getLastName()).isEmpty()) {
            return null;
        }
        return autorRepository.save(autor);
    }

    @Override
    public Autor edit(Autor autor) {
        Autor autorFound = findById(autor.getId());
        if (autorFound==null){
            return null;
        }
        if (autor.getName()!=null) {
            autorFound.setName(autor.getName());
        }
        if (autor.getLastName()!=null) {
            autorFound.setLastName(autor.getLastName());
        }
        if (autor.getBirthdate()!=null) {
            autorFound.setBirthdate(autor.getBirthdate());
        }
        if (autor.getEmail()!=null) {
            autorFound.setEmail(autor.getEmail());
        }
        if (!validarEntidad(autorFound)) {
            return null;
        }
        return autorRepository.save(autorFound);
    }

    @Override
    public void delete(Long id) {
        /*
        1. Validar de los campos cumplan los requisitos
        */
        Autor autorFound = findById(id);
        if (autorFound==null){
            return;
        }
        if (!autorFound.getSubscripciones().isEmpty()){
            return;
        }
        if (!autorFound.getProyectos().isEmpty()){
            return;
        }
        if (!autorFound.getColaboraciones().isEmpty()){
            return;
        }
        autorRepository.deleteById(id);
    }

    public Autor findById(Long id) {
        return autorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Autor> listAll() {
        return autorRepository.findAll();
    }
}
