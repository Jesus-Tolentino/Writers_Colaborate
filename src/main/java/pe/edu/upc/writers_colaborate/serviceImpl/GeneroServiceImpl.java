package pe.edu.upc.writers_colaborate.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.writers_colaborate.entities.Genero;
import pe.edu.upc.writers_colaborate.repositories.GeneroRepository;
import pe.edu.upc.writers_colaborate.services.GeneroService;

import java.util.List;

@Service
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    GeneroRepository generoRepository;

    public boolean validarEntidad(Genero genero){
        if (genero.getName()==null || genero.getName().isBlank()) {
            return false;
        }
        return true;
    }

    @Override
    public Genero add(Genero genero) {
        /*
        1. Validar de los campos cumplan los requisitos
        2. Grabar el genero en la BD
        */
        if (!validarEntidad(genero)) {
            return null;
        }
        //Validar si el nombre ya esta registrado
        if (!generoRepository.findByName(genero.getName()).isEmpty()) {
            //System.out.println(facultyRepository.findByName(faculty.getName()));
            return null;
        }
        return generoRepository.save(genero);
    }

    @Override
    public Genero edit(Genero genero) {
        Genero generoFound = findById(genero.getId());
        if (generoFound==null){
            return null;
        }
        if (genero.getName()!=null) {
            generoFound.setName(genero.getName());
        }
        if (genero.getDescription()!=null) {
            generoFound.setDescription(genero.getDescription());
        }
        return generoRepository.save(generoFound);
    }

    @Override
    public void delete(Long id) {
        /*
        1. Validar de los campos cumplan los requisitos
        */
        Genero generoFound = findById(id);
        if (generoFound==null){
            return;
        }
        if (!generoFound.getProyectos_generos().isEmpty()){
            return;
        }
        generoRepository.deleteById(id);
    }

    public Genero findById(Long id) {
        return generoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Genero> listAll() {
        return generoRepository.findAll();
    }
}
