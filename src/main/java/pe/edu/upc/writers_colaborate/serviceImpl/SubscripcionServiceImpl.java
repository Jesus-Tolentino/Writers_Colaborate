package pe.edu.upc.writers_colaborate.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.writers_colaborate.dtos.SubscripcionDTO;
import pe.edu.upc.writers_colaborate.entities.Autor;
import pe.edu.upc.writers_colaborate.entities.Subscripcion;
import pe.edu.upc.writers_colaborate.repositories.SubscripcionRepository;
import pe.edu.upc.writers_colaborate.services.AutorService;
import pe.edu.upc.writers_colaborate.services.SubscripcionService;

import java.util.List;

@Service
public class SubscripcionServiceImpl implements SubscripcionService {

    @Autowired
    public SubscripcionRepository subscripcionRepository;

    @Autowired
    public AutorService autorService;

    @Override
    public SubscripcionDTO add(SubscripcionDTO subscripcionDTO) {
        /*
        1. Validar de los campos cumplan los requisitos
        2. Grabar la carrera en la BD
        */

        Autor autorFound = autorService.findById(subscripcionDTO.getAutorId());
        if (autorFound==null) {
            return null;
        }
        if (subscripcionDTO.getType()==null || subscripcionDTO.getType().isBlank()) {
            return null;
        }
        if (subscripcionDTO.getDescription()==null || subscripcionDTO.getDescription().isBlank()) {
            return null;
        }
        if (subscripcionDTO.getStartDate()==null) {
            return null;
        }
        if (subscripcionDTO.getEndDate()==null) {
            return null;
        }
        if (subscripcionDTO.getPrice()==null) {
            return null;
        }
        if (subscripcionDTO.getAutoRenew()==null) {
            return null;
        }

        Subscripcion subscripcion = new Subscripcion(null, subscripcionDTO.getType(), subscripcionDTO.getDescription(),
                subscripcionDTO.getStartDate(), subscripcionDTO.getEndDate(), subscripcionDTO.getPrice(), subscripcionDTO.getAutoRenew(), autorFound);
        subscripcion = subscripcionRepository.save(subscripcion);

        subscripcionDTO.setId(subscripcion.getId());
        return subscripcionDTO;
    }

    @Override
    public Subscripcion edit(Subscripcion subscripcion) {
        return null;
    }

    @Override
    public void delete(Long id) {
        Subscripcion subscripcionFound = findById(id);
        if (subscripcionFound==null){
            return;
        }
        subscripcionRepository.deleteById(id);
    }

    @Override
    public Subscripcion findById(Long id) {
        return subscripcionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Subscripcion> listAll() {
        return subscripcionRepository.findAll();
    }

    @Override
    public List<Subscripcion> listByAutorId(Long id) {
        return subscripcionRepository.findByAutor_Id(id);
    }
}
