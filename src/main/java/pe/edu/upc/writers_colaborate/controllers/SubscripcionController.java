package pe.edu.upc.writers_colaborate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.writers_colaborate.dtos.SubscripcionDTO;
import pe.edu.upc.writers_colaborate.entities.Subscripcion;
import pe.edu.upc.writers_colaborate.services.SubscripcionService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/upc") //  http://localhost:8080/upc
public class SubscripcionController {

    @Autowired
    SubscripcionService subscripcionService;

    @GetMapping("/subscripciones")
    public ResponseEntity<List<Subscripcion>> listAll(){
        List<Subscripcion> subscripciones = subscripcionService.listAll();
        return new ResponseEntity<>(subscripciones, HttpStatus.OK);
    }

    @GetMapping("/subscripciones/{id}")
    public ResponseEntity<Subscripcion> findById(@PathVariable("id") Long id){
        Subscripcion foundSubscripcion = subscripcionService.findById(id);
        return new ResponseEntity<>(foundSubscripcion, HttpStatus.OK);
    }

    @GetMapping("/subscripciones/autor/{autorId}")
    public ResponseEntity<List<Subscripcion>> listByAutorId(@PathVariable("autorId") Long autorId){
        List<Subscripcion> subscripciones = subscripcionService.listByAutorId(autorId);
        return new ResponseEntity<>(subscripciones, HttpStatus.OK);
    }

    @PostMapping("/subscripciones")
    public ResponseEntity<SubscripcionDTO> add(@RequestBody SubscripcionDTO subscripcionDTO){
        subscripcionDTO = subscripcionService.add(subscripcionDTO);
        return new ResponseEntity<>(subscripcionDTO, HttpStatus.CREATED);
    }

    @PutMapping("/subscripciones")
    public ResponseEntity<Subscripcion> edit(@RequestBody Subscripcion subscripcion){
        Subscripcion editedSubscripcion = subscripcionService.edit(subscripcion);
        return new ResponseEntity<>(editedSubscripcion, HttpStatus.OK);
    }

    @DeleteMapping("/subscripciones/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        subscripcionService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
