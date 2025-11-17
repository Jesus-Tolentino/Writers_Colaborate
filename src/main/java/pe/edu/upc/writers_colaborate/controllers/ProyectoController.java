package pe.edu.upc.writers_colaborate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.writers_colaborate.dtos.ProyectoDTO;
import pe.edu.upc.writers_colaborate.entities.Proyecto;
import pe.edu.upc.writers_colaborate.services.ProyectoService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/upc") //  http://localhost:8080/upc
public class ProyectoController {

    @Autowired
    ProyectoService proyectoService;

    @GetMapping("/proyectos")
    public ResponseEntity<List<Proyecto>> listAll(){
        List<Proyecto> proyectos = proyectoService.listAll();
        return new ResponseEntity<>(proyectos, HttpStatus.OK);
    }

    @GetMapping("/proyectos/{id}")
    public ResponseEntity<Proyecto> findById(@PathVariable("id") Long id){
        Proyecto foundProyecto = proyectoService.findById(id);
        return new ResponseEntity<>(foundProyecto, HttpStatus.OK);
    }

    @GetMapping("/proyectos/autor/{autorId}")
    public ResponseEntity<List<Proyecto>> listByAutorId(@PathVariable("autorId") Long autorId){
        List<Proyecto> proyectos = proyectoService.listByAutorId(autorId);
        return new ResponseEntity<>(proyectos, HttpStatus.OK);
    }

    @PostMapping("/proyectos")
    public ResponseEntity<ProyectoDTO> add(@RequestBody ProyectoDTO proyectoDTO){
        proyectoDTO = proyectoService.add(proyectoDTO);
        return new ResponseEntity<>(proyectoDTO, HttpStatus.CREATED);
    }

    @PutMapping("/proyectos")
    public ResponseEntity<Proyecto> edit(@RequestBody Proyecto proyecto){
        Proyecto editedProyecto = proyectoService.edit(proyecto);
        return new ResponseEntity<>(editedProyecto, HttpStatus.OK);
    }

    @DeleteMapping("/proyectos/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        proyectoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
