package exhodus.demo.controllers;

import exhodus.demo.DTOS.PatronInsertDTO;
import exhodus.demo.DTOS.PatronSimpleDTO;
import exhodus.demo.model.Images;
import exhodus.demo.model.Patrons;
import exhodus.demo.repositories.ImageRespository;
import exhodus.demo.services.ImageService;
import exhodus.demo.services.PatronImageService;
import exhodus.demo.services.PatronsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patrons")
public class PatronsController {

    private final PatronsService service;
    private final ImageService imageService;
    private final PatronImageService patronImageService;

    public PatronsController(ImageService imageService, PatronsService patronService, PatronImageService patronImageService) {
        this.imageService = imageService;
        this.service = patronService;
        this.patronImageService = patronImageService;
    }

    //CREATE
    @PostMapping("/create")
    public ResponseEntity<?> createPatron(@RequestBody PatronInsertDTO patron, @RequestParam(required = false) MultipartFile file){
        System.err.println("PATRON EN CONTROLLER: "+patron.toString() );
        Patrons inserted = service.createPatron(patron.getNombre(), patron.getDescripcion(), patron.getDificultad(), patron.getTiempoEstimadoHoras(), 1);

        if(inserted != null){

            if(file != null){
                String urlImage = imageService.uploadImage(file);
                Images img = new Images();
                img.set_idPatron(inserted);
                img.set_url(urlImage);
                patronImageService.uploadImage(img.get_url(), img.get_idPatron().getId(), "", img.get_type());
            }
            return ResponseEntity.status(HttpStatus.CREATED).body("Patrón creado con éxito");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se ha podido crear el patrón.");
        }
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

}
