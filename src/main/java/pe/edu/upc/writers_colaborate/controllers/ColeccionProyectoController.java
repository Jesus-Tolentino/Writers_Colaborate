package pe.edu.upc.writers_colaborate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.writers_colaborate.dtos.ColeccionProyectoDTO;
import pe.edu.upc.writers_colaborate.entities.ColeccionProyecto;
import pe.edu.upc.writers_colaborate.services.ColeccionProyectoService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/upc") //  http://localhost:8080/upc
public class ColeccionProyectoController {

    @Autowired
    ColeccionProyectoService coleccionProyectoService;

    @GetMapping("/colecciones_proyectos")
    public ResponseEntity<List<ColeccionProyecto>> listAll(){
        List<ColeccionProyecto> coleccionesProyectos = coleccionProyectoService.listAll();
        return new ResponseEntity<>(coleccionesProyectos, HttpStatus.OK);
    }

    @GetMapping("/colecciones_proyectos/{id}")
    public ResponseEntity<ColeccionProyecto> findById(@PathVariable("id") Long id){
        ColeccionProyecto foundColeccionProyecto = coleccionProyectoService.findById(id);
        return new ResponseEntity<>(foundColeccionProyecto, HttpStatus.OK);
    }

    @GetMapping("/colecciones_proyectos/coleccion/{coleccionId}")
    public ResponseEntity<List<ColeccionProyecto>> listByColeccionId(@PathVariable("coleccionId") Long coleccionId){
        List<ColeccionProyecto> coleccionesProyectos = coleccionProyectoService.listByColeccionId(coleccionId);
        return new ResponseEntity<>(coleccionesProyectos, HttpStatus.OK);
    }

    @GetMapping("/colecciones_proyectos/proyecto/{proyectoId}")
    public ResponseEntity<List<ColeccionProyecto>> listByProyectoId(@PathVariable("proyectoId") Long proyectoId){
        List<ColeccionProyecto> coleccionesProyectos = coleccionProyectoService.listByProyectoId(proyectoId);
        return new ResponseEntity<>(coleccionesProyectos, HttpStatus.OK);
    }

    @PostMapping("/colecciones_proyectos")
    public ResponseEntity<ColeccionProyectoDTO> add(@RequestBody ColeccionProyectoDTO coleccionProyectoDTO){
        coleccionProyectoDTO = coleccionProyectoService.add(coleccionProyectoDTO);
        return new ResponseEntity<>(coleccionProyectoDTO, HttpStatus.CREATED);
    }

    @PutMapping("/colecciones_proyectos")
    public ResponseEntity<ColeccionProyecto> edit(@RequestBody ColeccionProyecto coleccionProyecto){
        ColeccionProyecto editedColeccionProyecto = coleccionProyectoService.edit(coleccionProyecto);
        return new ResponseEntity<>(editedColeccionProyecto, HttpStatus.OK);
    }

    @DeleteMapping("/colecciones_proyectos/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        coleccionProyectoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
