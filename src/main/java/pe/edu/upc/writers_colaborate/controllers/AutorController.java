package pe.edu.upc.writers_colaborate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.writers_colaborate.entities.Autor;
import pe.edu.upc.writers_colaborate.services.AutorService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/upc") //  http://localhost:8080/upc
public class AutorController {

    @Autowired
    AutorService autorService;

    //    http://localhost:8080/upc/autores  -> Utilizando la peticion GET
    @GetMapping("/autores")
    public ResponseEntity<List<Autor>> listAll(){
        List<Autor> autores = autorService.listAll();
        return new ResponseEntity<>(autores, HttpStatus.OK);
    }

    //    http://localhost:8080/upc/autores  -> Utilizando la peticion POST
    @PostMapping("/autores")
    public ResponseEntity<Autor> add(@RequestBody Autor autor){
        Autor newAutor = autorService.add(autor);
        return new ResponseEntity<>(newAutor, HttpStatus.CREATED);
    }

    //    http://localhost:8080/upc/autores/ID  -> Utilizando la peticion GET
    @GetMapping("/autores/{id}")
    public ResponseEntity<Autor> findById(@PathVariable("id") Long id){
        Autor foundAutor = autorService.findById(id);
        return new ResponseEntity<>(foundAutor, HttpStatus.OK);
    }

    //    http://localhost:8080/upc/autores/ID  -> Utilizando la peticion DELETE
    @DeleteMapping("/autores/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        autorService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //    http://localhost:8080/upc/autores -> Utilizando la peticion PUT
    @PutMapping("/autores")
    public ResponseEntity<Autor> edit(@RequestBody Autor autor){
        Autor editedAutor = autorService.edit(autor);
        return new ResponseEntity<>(editedAutor, HttpStatus.OK);
    }
}
