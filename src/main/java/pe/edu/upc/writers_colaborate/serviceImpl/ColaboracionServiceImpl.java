package pe.edu.upc.writers_colaborate.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.writers_colaborate.dtos.ColaboracionDTO;
import pe.edu.upc.writers_colaborate.entities.Autor;
import pe.edu.upc.writers_colaborate.entities.Capitulo;
import pe.edu.upc.writers_colaborate.entities.Colaboracion;
import pe.edu.upc.writers_colaborate.repositories.ColaboracionRepository;
import pe.edu.upc.writers_colaborate.services.AutorService;
import pe.edu.upc.writers_colaborate.services.CapituloService;
import pe.edu.upc.writers_colaborate.services.ColaboracionService;

import java.util.List;

@Service
public class ColaboracionServiceImpl implements ColaboracionService {

    @Autowired
    public ColaboracionRepository colaboracionRepository;

    @Autowired
    public AutorService autorService;

    @Autowired
    public CapituloService capituloService;

    @Override
    public ColaboracionDTO add(ColaboracionDTO colaboracionDTO) {
        /*
        1. Validar de los campos cumplan los requisitos
        2. Grabar la colaboracion en la BD
        */

        Autor autorFound = autorService.findById(colaboracionDTO.getAutorId());
        if (autorFound==null) {
            return null;
        }
        Capitulo capituloFound = capituloService.findById(colaboracionDTO.getCapituloId());
        if (capituloFound==null) {
            return null;
        }
        if (colaboracionDTO.getCreationDate()==null) {
            return null;
        }
        if (colaboracionDTO.getCompletionDate()==null) {
            return null;
        }
        if (colaboracionDTO.getRol()==null || colaboracionDTO.getRol().isBlank()) {
            return null;
        }
        if (colaboracionDTO.getDescription()==null|| colaboracionDTO.getDescription().isBlank()) {
            return null;
        }
        if (colaboracionDTO.getState()==null|| colaboracionDTO.getState().isBlank()) {
            return null;
        }

        Colaboracion colaboracion = new Colaboracion(null, colaboracionDTO.getCreationDate(), colaboracionDTO.getCompletionDate(),
                colaboracionDTO.getRol(), colaboracionDTO.getDescription(), colaboracionDTO.getState(), autorFound, capituloFound);
        colaboracion = colaboracionRepository.save(colaboracion);

        colaboracionDTO.setId(colaboracion.getId());
        return colaboracionDTO;
    }

    @Override
    public Colaboracion edit(Colaboracion colaboracion) {
        return null;
    }

    @Override
    public void delete(Long id) {
        Colaboracion colaboracionFound = findById(id);
        if (colaboracionFound==null){
            return;
        }
        colaboracionRepository.deleteById(id);
    }

    @Override
    public Colaboracion findById(Long id) {
        return colaboracionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Colaboracion> listAll() {
        return colaboracionRepository.findAll();
    }

    @Override
    public List<Colaboracion> listByAutorId(Long id) {
        return colaboracionRepository.findByAutor_Id(id);
    }

    @Override
    public List<Colaboracion> listByCapituloId(Long id) {
        return colaboracionRepository.findByCapitulo_Id(id);
    }
}
