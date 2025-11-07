package exhodus.demo.controllers;

import exhodus.demo.model.Patrons;
import exhodus.demo.services.PatronsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/patrons")
public class PatronsController {

    @Autowired
    PatronsService service;

    //CREATE
    @GetMapping("/create")
    public String createPatron(@RequestParam String name, @RequestParam String desc, @RequestParam int diff,  @RequestParam int time, @RequestParam int user){
        System.err.println("CONTROLLER: "+name + " "+ desc + " "+ diff +" "+ time+" "+user );
        int res = service.createPatron(name, desc,diff,time,user);
        if(res == 1){
            return "Todo ok.";
        } else {
            return "Error.";
        }
    }

    //GETS
    @GetMapping("/user/{id}")
    public List<Patrons> getPatronsByUserId(@PathVariable int id){
        return service.getPatronsByUserId(id);
    }

    @GetMapping("/{id}")
    public Patrons getPatronById(@PathVariable int id){
        return service.getPatronById(id);
    }

    //UPDATE

}
