package pe.edu.upc.writers_colaborate.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.writers_colaborate.dtos.ColeccionProyectoDTO;
import pe.edu.upc.writers_colaborate.entities.*;
import pe.edu.upc.writers_colaborate.repositories.ColeccionProyectoRepository;
import pe.edu.upc.writers_colaborate.services.*;

import java.util.List;

@Service
public class ColeccionProyectoServiceImpl implements ColeccionProyectoService {

    @Autowired
    public ColeccionProyectoRepository coleccionProyectoRepository;

    @Autowired
    public ColeccionService coleccionService;

    @Autowired
    public ProyectoService proyectoService;

    @Override
    public ColeccionProyectoDTO add(ColeccionProyectoDTO coleccionProyectoDTO) {
        /*
        1. Validar de los campos cumplan los requisitos
        2. Grabar la coleccionProyecto en la BD
        */

        Coleccion coleccionFound = coleccionService.findById(coleccionProyectoDTO.getColeccionId());
        if (coleccionFound==null) {
            return null;
        }
        Proyecto proyectoFound = proyectoService.findById(coleccionProyectoDTO.getProyectoId());
        if (proyectoFound==null) {
            return null;
        }
        if (coleccionProyectoDTO.getAsignmentDate()==null) {
            return null;
        }
        if (coleccionProyectoDTO.getAmount()==null) {
            return null;
        }
        if (coleccionProyectoDTO.getDescription()==null || coleccionProyectoDTO.getDescription().isBlank()) {
            return null;
        }

        ColeccionProyecto coleccionProyecto = new ColeccionProyecto(null, coleccionProyectoDTO.getAsignmentDate(), coleccionProyectoDTO.getAmount(),
                coleccionProyectoDTO.getDescription(), coleccionFound, proyectoFound);
        coleccionProyecto = coleccionProyectoRepository.save(coleccionProyecto);

        coleccionProyectoDTO.setId(coleccionProyecto.getId());
        return coleccionProyectoDTO;
    }

    @Override
    public ColeccionProyecto edit(ColeccionProyecto coleccionProyecto) {
        return null;
    }

    @Override
    public void delete(Long id) {
        ColeccionProyecto coleccionProyectoFound = findById(id);
        if (coleccionProyectoFound==null){
            return;
        }
        coleccionProyectoRepository.deleteById(id);
    }

    @Override
    public ColeccionProyecto findById(Long id) {
        return coleccionProyectoRepository.findById(id).orElse(null);
    }

    @Override
    public List<ColeccionProyecto> listAll() {
        return coleccionProyectoRepository.findAll();
    }

    @Override
    public List<ColeccionProyecto> listByColeccionId(Long id) {
        return coleccionProyectoRepository.findByColeccion_Id(id);
    }

    @Override
    public List<ColeccionProyecto> listByProyectoId(Long id) {
        return coleccionProyectoRepository.findByProyecto_Id(id);
    }
}
