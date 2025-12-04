package pe.edu.upc.writers_colaborate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.writers_colaborate.dtos.NotificacionDTO;
import pe.edu.upc.writers_colaborate.entities.Notificacion;
import pe.edu.upc.writers_colaborate.services.NotificacionService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/upc") //  http://localhost:8080/upc
public class NotificacionController {

    @Autowired
    NotificacionService notificacionService;

    @GetMapping("/notificaciones")
    public ResponseEntity<List<Notificacion>> listAll(){
        List<Notificacion> notificaciones = notificacionService.listAll();
        return new ResponseEntity<>(notificaciones, HttpStatus.OK);
    }

    @GetMapping("/notificaciones/{id}")
    public ResponseEntity<Notificacion> findById(@PathVariable("id") Long id){
        Notificacion foundNotificacion = notificacionService.findById(id);
        return new ResponseEntity<>(foundNotificacion, HttpStatus.OK);
    }

    @GetMapping("/notificaciones/proyecto/{proyectoId}")
    public ResponseEntity<List<Notificacion>> listByProyectoId(@PathVariable("proyectoId") Long proyectoId){
        List<Notificacion> notificaciones = notificacionService.listByProyectoId(proyectoId);
        return new ResponseEntity<>(notificaciones, HttpStatus.OK);
    }

    @PostMapping("/notificaciones")
    public ResponseEntity<NotificacionDTO> add(@RequestBody NotificacionDTO notificacionDTO){
        notificacionDTO = notificacionService.add(notificacionDTO);
        return new ResponseEntity<>(notificacionDTO, HttpStatus.CREATED);
    }

    @PutMapping("/notificaciones")
    public ResponseEntity<Notificacion> edit(@RequestBody Notificacion notificacion){
        Notificacion editedNotificacion = notificacionService.edit(notificacion);
        return new ResponseEntity<>(editedNotificacion, HttpStatus.OK);
    }

    @DeleteMapping("/notificaciones/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        notificacionService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
