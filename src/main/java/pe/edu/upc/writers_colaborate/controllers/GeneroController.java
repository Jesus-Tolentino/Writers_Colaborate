package pe.edu.upc.writers_colaborate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.writers_colaborate.entities.Autor;
import pe.edu.upc.writers_colaborate.entities.Genero;
import pe.edu.upc.writers_colaborate.services.GeneroService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/upc") //  http://localhost:8080/upc
public class GeneroController {

    @Autowired
    GeneroService generoService;

    //    http://localhost:8080/upc/generos  -> Utilizando la peticion GET
    @GetMapping("/generos")
    public ResponseEntity<List<Genero>> listAll(){
        List<Genero> generos = generoService.listAll();
        return new ResponseEntity<>(generos, HttpStatus.OK);
    }

    //    http://localhost:8080/upc/generos  -> Utilizando la peticion POST
    @PostMapping("/generos")
    public ResponseEntity<Genero> add(@RequestBody Genero genero){
        Genero newGenero = generoService.add(genero);
        return new ResponseEntity<>(newGenero, HttpStatus.CREATED);
    }

    //    http://localhost:8080/upc/generos/ID  -> Utilizando la peticion GET
    @GetMapping("/generos/{id}")
    public ResponseEntity<Genero> findById(@PathVariable("id") Long id){
        Genero foundGenero = generoService.findById(id);
        return new ResponseEntity<>(foundGenero, HttpStatus.OK);
    }

    //    http://localhost:8080/upc/generos/ID  -> Utilizando la peticion DELETE
    @DeleteMapping("/generos/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        generoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //    http://localhost:8080/upc/generos -> Utilizando la peticion PUT
    @PutMapping("/generos")
    public ResponseEntity<Genero> edit(@RequestBody Genero genero){
        Genero editedGenero = generoService.edit(genero);
        return new ResponseEntity<>(editedGenero, HttpStatus.OK);
    }
}
