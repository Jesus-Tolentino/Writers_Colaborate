package pe.edu.upc.writers_colaborate.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.writers_colaborate.dtos.ProyectoGeneroDTO;
import pe.edu.upc.writers_colaborate.entities.*;
import pe.edu.upc.writers_colaborate.repositories.ProyectoGeneroRepository;
import pe.edu.upc.writers_colaborate.services.GeneroService;
import pe.edu.upc.writers_colaborate.services.ProyectoGeneroService;
import pe.edu.upc.writers_colaborate.services.ProyectoService;

import java.util.List;

@Service
public class ProyectoGeneroServiceImpl implements ProyectoGeneroService {

    @Autowired
    private ProyectoGeneroRepository proyectoGeneroRepository;

    @Autowired
    private ProyectoService proyectoService;

    @Autowired
    private GeneroService generoService;

    @Override
    public ProyectoGeneroDTO add(ProyectoGeneroDTO proyectoGeneroDTO) {
        /*
        1. Validar de los campos cumplan los requisitos
        2. Grabar la colaboracion en la BD
        */

        Proyecto proyectoFound = proyectoService.findById(proyectoGeneroDTO.getProyectoId());
        if (proyectoFound==null) {
            return null;
        }
        Genero generoFound = generoService.findById(proyectoGeneroDTO.getGeneroId());
        if (generoFound==null) {
            return null;
        }
        if (proyectoGeneroDTO.getAsignmentDate()==null) {
            return null;
        }
        if (proyectoGeneroDTO.getMain()==null || proyectoGeneroDTO.getMain().isBlank()) {
            return null;
        }
        if (proyectoGeneroDTO.getSub()==null || proyectoGeneroDTO.getSub().isBlank()) {
            return null;
        }

        ProyectoGenero proyectoGenero = new ProyectoGenero(null, proyectoGeneroDTO.getAsignmentDate(), proyectoGeneroDTO.getMain(),
                proyectoGeneroDTO.getSub(), proyectoFound, generoFound);
        proyectoGenero = proyectoGeneroRepository.save(proyectoGenero);

        proyectoGeneroDTO.setId(proyectoGenero.getId());
        return proyectoGeneroDTO;
    }

    @Override
    public ProyectoGenero edit(ProyectoGenero proyectoGenero) {
        return null;
    }

    @Override
    public void delete(Long id) {
        ProyectoGenero proyectoGeneroFound = findById(id);
        if (proyectoGeneroFound==null){
            return;
        }
        proyectoGeneroRepository.deleteById(id);
    }

    @Override
    public ProyectoGenero findById(Long id) {
        return proyectoGeneroRepository.findById(id).orElse(null);
    }

    @Override
    public List<ProyectoGenero> listAll() {
        return proyectoGeneroRepository.findAll();
    }

    @Override
    public List<ProyectoGenero> listByProyectoId(Long id) {
        return proyectoGeneroRepository.findByProyecto_Id(id);
    }

    @Override
    public List<ProyectoGenero> listByGeneroId(Long id) {
        return proyectoGeneroRepository.findByGenero_Id(id);
    }

}
