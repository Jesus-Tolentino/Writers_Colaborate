package pe.edu.upc.writers_colaborate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.writers_colaborate.dtos.ReunionDTO;
import pe.edu.upc.writers_colaborate.entities.Reunion;
import pe.edu.upc.writers_colaborate.services.ReunionService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/upc") //  http://localhost:8080/upc
public class ReunionController {

    @Autowired
    ReunionService reunionService;

    @GetMapping("/reuniones")
    public ResponseEntity<List<Reunion>> listAll(){
        List<Reunion> reuniones = reunionService.listAll();
        return new ResponseEntity<>(reuniones, HttpStatus.OK);
    }

    @GetMapping("/reuniones/{id}")
    public ResponseEntity<Reunion> findById(@PathVariable("id") Long id){
        Reunion foundReunion = reunionService.findById(id);
        return new ResponseEntity<>(foundReunion, HttpStatus.OK);
    }

    @GetMapping("/reuniones/proyecto/{proyectoId}")
    public ResponseEntity<List<Reunion>> listByProyectoId(@PathVariable("proyectoId") Long proyectoId){
        List<Reunion> reuniones = reunionService.listByProyectoId(proyectoId);
        return new ResponseEntity<>(reuniones, HttpStatus.OK);
    }

    @PostMapping("/reuniones")
    public ResponseEntity<ReunionDTO> add(@RequestBody ReunionDTO reunionDTO){
        reunionDTO = reunionService.add(reunionDTO);
        return new ResponseEntity<>(reunionDTO, HttpStatus.CREATED);
    }

    @PutMapping("/reuniones")
    public ResponseEntity<Reunion> edit(@RequestBody Reunion reunion){
        Reunion editedReunion = reunionService.edit(reunion);
        return new ResponseEntity<>(editedReunion, HttpStatus.OK);
    }

    @DeleteMapping("/reuniones/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        reunionService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
