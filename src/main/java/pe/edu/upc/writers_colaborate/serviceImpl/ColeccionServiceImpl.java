package pe.edu.upc.writers_colaborate.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.writers_colaborate.entities.Coleccion;
import pe.edu.upc.writers_colaborate.repositories.ColeccionRepository;
import pe.edu.upc.writers_colaborate.services.ColeccionService;

import java.util.List;

@Service
public class ColeccionServiceImpl implements ColeccionService {

    @Autowired
    ColeccionRepository coleccionRepository;

    public boolean validarEntidad(Coleccion coleccion){
        if (coleccion.getTitle()==null || coleccion.getTitle().isBlank()) {
            return false;
        }
        if (coleccion.getCreator()==null || coleccion.getCreator().isBlank()) {
            return false;
        }
        if (coleccion.getCreationDate()==null) {
            return false;
        }
        if (coleccion.getEnabled()==null){ //|| coleccion.getEnabled()==Boolean.FALSE) {
            return false;
        }
        return true;
    }

    @Override
    public Coleccion add(Coleccion coleccion) {
        /*
        1. Validar que los campos cumplan los requisitos
        2. Grabar la facultad en la BD
        */
        if (!validarEntidad(coleccion)) {
            return null;
        }
        //Validar si la coleccion ya esta registrada
        if (!coleccionRepository.findByTitle(coleccion.getTitle()).isEmpty()) {
            //System.out.println(facultyRepository.findByName(faculty.getName()));
            return null;
        }
        if (!coleccionRepository.findByCreationDate(coleccion.getCreationDate()).isEmpty()) {
            return null;
        }
        return coleccionRepository.save(coleccion);
    }

    @Override
    public Coleccion edit(Coleccion coleccion) {
        Coleccion coleccionFound = findById(coleccion.getId());
        if (coleccionFound==null){
            return null;
        }
        if (coleccion.getTitle()!=null) {
            coleccionFound.setTitle(coleccion.getTitle());
        }
        if (coleccion.getType()!=null) {
            coleccionFound.setType(coleccion.getType());
        }
        if (coleccion.getDescription()!=null) {
            coleccionFound.setDescription(coleccion.getDescription());
        }
        if (coleccion.getCreationDate()!=null) {
            coleccionFound.setCreationDate(coleccion.getCreationDate());
        }
        if (coleccion.getEnabled()!=null) {
            coleccionFound.setEnabled(coleccion.getEnabled());
        }
        if (coleccion.getCreator()!=null) {
            coleccionFound.setCreator(coleccion.getCreator());
        }
        if (!validarEntidad(coleccionFound)) {
            return null;
        }
        return coleccionRepository.save(coleccionFound);
    }

    @Override
    public void delete(Long id) {
        /*
        1. Validar de los campos cumplan los requisitos
        2. Grabar la facultad en la BD
        */
        Coleccion coleccionFound = findById(id);
        if (coleccionFound==null){
            return;
        }
        if (!coleccionFound.getColecciones_proyectos().isEmpty()){
            return;
        }
        coleccionRepository.deleteById(id);
    }

    public Coleccion findById(Long id) {
        return coleccionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Coleccion> listAll() {
        return coleccionRepository.findAll();
    }
}
