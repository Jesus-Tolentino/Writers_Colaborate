package pe.edu.upc.writers_colaborate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.writers_colaborate.dtos.ColaboracionDTO;
import pe.edu.upc.writers_colaborate.entities.Colaboracion;
import pe.edu.upc.writers_colaborate.services.ColaboracionService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/upc") //  http://localhost:8080/upc
public class ColaboracionController {

    @Autowired
    ColaboracionService colaboracionService;

    @GetMapping("/colaboraciones")
    public ResponseEntity<List<Colaboracion>> listAll(){
        List<Colaboracion> colaboraciones = colaboracionService.listAll();
        return new ResponseEntity<>(colaboraciones, HttpStatus.OK);
    }

    @GetMapping("/colaboraciones/{id}")
    public ResponseEntity<Colaboracion> findById(@PathVariable("id") Long id){
        Colaboracion foundColaboracion = colaboracionService.findById(id);
        return new ResponseEntity<>(foundColaboracion, HttpStatus.OK);
    }

    @GetMapping("/colaboraciones/autor/{autorId}")
    public ResponseEntity<List<Colaboracion>> listByAutorId(@PathVariable("autorId") Long autorId){
        List<Colaboracion> colaboraciones = colaboracionService.listByAutorId(autorId);
        return new ResponseEntity<>(colaboraciones, HttpStatus.OK);
    }

    @GetMapping("/colaboraciones/capitulo/{capituloId}")
    public ResponseEntity<List<Colaboracion>> listByCapituloId(@PathVariable("capituloId") Long capituloId){
        List<Colaboracion> colaboraciones = colaboracionService.listByCapituloId(capituloId);
        return new ResponseEntity<>(colaboraciones, HttpStatus.OK);
    }

    @PostMapping("/colaboraciones")
    public ResponseEntity<ColaboracionDTO> add(@RequestBody ColaboracionDTO colaboracionDTO){
        colaboracionDTO = colaboracionService.add(colaboracionDTO);
        return new ResponseEntity<>(colaboracionDTO, HttpStatus.CREATED);
    }

    @PutMapping("/colaboraciones")
    public ResponseEntity<Colaboracion> edit(@RequestBody Colaboracion colaboracion){
        Colaboracion editedColaboracion = colaboracionService.edit(colaboracion);
        return new ResponseEntity<>(editedColaboracion, HttpStatus.OK);
    }

    @DeleteMapping("/colaboraciones/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        colaboracionService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
