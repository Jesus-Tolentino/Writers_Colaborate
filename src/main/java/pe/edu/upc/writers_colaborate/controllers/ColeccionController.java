package pe.edu.upc.writers_colaborate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.writers_colaborate.entities.Autor;
import pe.edu.upc.writers_colaborate.entities.Coleccion;
import pe.edu.upc.writers_colaborate.services.ColeccionService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/upc") //  http://localhost:8080/upc
public class ColeccionController {

    @Autowired
    ColeccionService coleccionService;

    //    http://localhost:8080/upc/colecciones  -> Utilizando la peticion GET
    @GetMapping("/colecciones")
    public ResponseEntity<List<Coleccion>> listAll(){
        List<Coleccion> colecciones = coleccionService.listAll();
        return new ResponseEntity<>(colecciones, HttpStatus.OK);
    }

    //    http://localhost:8080/upc/colecciones  -> Utilizando la peticion POST
    @PostMapping("/colecciones")
    public ResponseEntity<Coleccion> add(@RequestBody Coleccion coleccion){
        Coleccion newColeccion = coleccionService.add(coleccion);
        return new ResponseEntity<>(newColeccion, HttpStatus.CREATED);
    }

    //    http://localhost:8080/upc/colecciones/ID  -> Utilizando la peticion GET
    @GetMapping("/colecciones/{id}")
    public ResponseEntity<Coleccion> findById(@PathVariable("id") Long id){
        Coleccion foundColeccion = coleccionService.findById(id);
        return new ResponseEntity<>(foundColeccion, HttpStatus.OK);
    }

    //    http://localhost:8080/upc/colecciones/ID  -> Utilizando la peticion DELETE
    @DeleteMapping("/colecciones/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        coleccionService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //    http://localhost:8080/upc/colecciones -> Utilizando la peticion PUT
    @PutMapping("/colecciones")
    public ResponseEntity<Coleccion> edit(@RequestBody Coleccion coleccion){
        Coleccion editedColeccion = coleccionService.edit(coleccion);
        return new ResponseEntity<>(editedColeccion, HttpStatus.OK);
    }
}
