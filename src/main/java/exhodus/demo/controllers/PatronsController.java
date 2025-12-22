package exhodus.demo.controllers;

import exhodus.demo.DTOS.PatronInsertDTO;
import exhodus.demo.DTOS.PatronSimpleDTO;
import exhodus.demo.model.Patrons;
import exhodus.demo.services.PatronsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patrons")
public class PatronsController {

    @Autowired
    PatronsService service;

    //CREATE
    @PostMapping("/create")
    public ResponseEntity<?> createPatron(@RequestBody PatronInsertDTO patron){
        System.err.println("PATRON EN CONTROLLER: "+patron.toString() );
        return service.createPatron(patron.getNombre(), patron.getDescripcion(), patron.getDificultad(), patron.getTiempoEstimadoHoras(), 1);
    }

    //GETS
    @GetMapping("/user/{id}")
    public List<PatronSimpleDTO> getPatronsByUserId(@PathVariable int id){
        return service.getPatronsByUserId(id);
    }

    @GetMapping("/{id}")
    public Patrons getPatronById(@PathVariable int id){
        return service.getPatronById(id);
    }

    //UPDATE

}
