package pe.edu.upc.writers_colaborate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.writers_colaborate.dtos.ComentarioDTO;
import pe.edu.upc.writers_colaborate.entities.Comentario;
import pe.edu.upc.writers_colaborate.services.ComentarioService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/upc") //  http://localhost:8080/upc
public class ComentarioController {

    @Autowired
    ComentarioService comentarioService;

    @GetMapping("/comentarios")
    public ResponseEntity<List<Comentario>> listAll(){
        List<Comentario> comentarios = comentarioService.listAll();
        return new ResponseEntity<>(comentarios, HttpStatus.OK);
    }

    @GetMapping("/comentarios/{id}")
    public ResponseEntity<Comentario> findById(@PathVariable("id") Long id){
        Comentario foundComentario = comentarioService.findById(id);
        return new ResponseEntity<>(foundComentario, HttpStatus.OK);
    }

    @GetMapping("/comentarios/autor/{autorId}")
    public ResponseEntity<List<Comentario>> listByAutorId(@PathVariable("autorId") Long autorId){
        List<Comentario> comentarios = comentarioService.listByAutorId(autorId);
        return new ResponseEntity<>(comentarios, HttpStatus.OK);
    }

    @GetMapping("/comentarios/proyecto/{proyectoId}")
    public ResponseEntity<List<Comentario>> listByProyectoId(@PathVariable("proyectoId") Long proyectoId){
        List<Comentario> comentarios = comentarioService.listByProyectoId(proyectoId);
        return new ResponseEntity<>(comentarios, HttpStatus.OK);
    }

    @PostMapping("/comentarios")
    public ResponseEntity<ComentarioDTO> add(@RequestBody ComentarioDTO comentarioDTO){
        comentarioDTO = comentarioService.add(comentarioDTO);
        return new ResponseEntity<>(comentarioDTO, HttpStatus.CREATED);
    }

    @PutMapping("/comentarios")
    public ResponseEntity<Comentario> edit(@RequestBody Comentario comentario){
        Comentario editedComentario = comentarioService.edit(comentario);
        return new ResponseEntity<>(editedComentario, HttpStatus.OK);
    }

    @DeleteMapping("/comentarios/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        comentarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
