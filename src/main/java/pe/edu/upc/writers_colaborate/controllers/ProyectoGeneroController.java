package pe.edu.upc.writers_colaborate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.writers_colaborate.dtos.ProyectoGeneroDTO;
import pe.edu.upc.writers_colaborate.entities.ProyectoGenero;
import pe.edu.upc.writers_colaborate.services.ProyectoGeneroService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/upc") //  http://localhost:8080/upc
public class ProyectoGeneroController {

    @Autowired
    ProyectoGeneroService proyectoGeneroService;

    @GetMapping("/proyectos_generos")
    public ResponseEntity<List<ProyectoGenero>> listAll(){
        List<ProyectoGenero> proyectosGeneros = proyectoGeneroService.listAll();
        return new ResponseEntity<>(proyectosGeneros, HttpStatus.OK);
    }

    @GetMapping("/proyectos_generos/{id}")
    public ResponseEntity<ProyectoGenero> findById(@PathVariable("id") Long id){
        ProyectoGenero foundProyectoGenero = proyectoGeneroService.findById(id);
        return new ResponseEntity<>(foundProyectoGenero, HttpStatus.OK);
    }

    @GetMapping("/proyectos_generos/proyecto/{proyectoId}")
    public ResponseEntity<List<ProyectoGenero>> listByProyectoId(@PathVariable("proyectoId") Long proyectoId){
        List<ProyectoGenero> proyectosGeneros = proyectoGeneroService.listByProyectoId(proyectoId);
        return new ResponseEntity<>(proyectosGeneros, HttpStatus.OK);
    }

    @GetMapping("/proyectos_generos/genero/{generoId}")
    public ResponseEntity<List<ProyectoGenero>> listByGeneroId(@PathVariable("generoId") Long generoId){
        List<ProyectoGenero> proyectosGeneros = proyectoGeneroService.listByGeneroId(generoId);
        return new ResponseEntity<>(proyectosGeneros, HttpStatus.OK);
    }

    @PostMapping("/proyectos_generos")
    public ResponseEntity<ProyectoGeneroDTO> add(@RequestBody ProyectoGeneroDTO proyectoGeneroDTO){
        proyectoGeneroDTO = proyectoGeneroService.add(proyectoGeneroDTO);
        return new ResponseEntity<>(proyectoGeneroDTO, HttpStatus.CREATED);
    }

    @PutMapping("/proyectos_generos")
    public ResponseEntity<ProyectoGenero> edit(@RequestBody ProyectoGenero proyectoGenero){
        ProyectoGenero editedProyectoGenero = proyectoGeneroService.edit(proyectoGenero);
        return new ResponseEntity<>(editedProyectoGenero, HttpStatus.OK);
    }

    @DeleteMapping("/proyectos_generos/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        proyectoGeneroService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
