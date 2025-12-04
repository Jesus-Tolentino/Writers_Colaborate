package pe.edu.upc.writers_colaborate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.writers_colaborate.dtos.CapituloDTO;
import pe.edu.upc.writers_colaborate.entities.Capitulo;
import pe.edu.upc.writers_colaborate.services.CapituloService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/upc") //  http://localhost:8080/upc
public class CapituloController {

    @Autowired
    CapituloService capituloService;

    @GetMapping("/capitulos")
    public ResponseEntity<List<Capitulo>> listAll(){
        List<Capitulo> capitulos = capituloService.listAll();
        return new ResponseEntity<>(capitulos, HttpStatus.OK);
    }

    @GetMapping("/capitulos/{id}")
    public ResponseEntity<Capitulo> findById(@PathVariable("id") Long id){
        Capitulo foundCapitulo = capituloService.findById(id);
        return new ResponseEntity<>(foundCapitulo, HttpStatus.OK);
    }

    @GetMapping("/capitulos/proyecto/{proyectoId}")
    public ResponseEntity<List<Capitulo>> listByProyectoId(@PathVariable("proyectoId") Long proyectoId){
        List<Capitulo> capitulos = capituloService.listByProyectoId(proyectoId);
        return new ResponseEntity<>(capitulos, HttpStatus.OK);
    }

    @PostMapping("/capitulos")
    public ResponseEntity<CapituloDTO> add(@RequestBody CapituloDTO capituloDTO){
        capituloDTO = capituloService.add(capituloDTO);
        return new ResponseEntity<>(capituloDTO, HttpStatus.CREATED);
    }

    @PutMapping("/capitulos")
    public ResponseEntity<Capitulo> edit(@RequestBody Capitulo capitulo){
        Capitulo editedCapitulo = capituloService.edit(capitulo);
        return new ResponseEntity<>(editedCapitulo, HttpStatus.OK);
    }

    @DeleteMapping("/capitulos/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        capituloService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
