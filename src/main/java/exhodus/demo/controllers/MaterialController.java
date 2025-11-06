package exhodus.demo.controllers;

import exhodus.demo.model.Materials;
import exhodus.demo.services.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    MaterialService service;

    @GetMapping("/create")
    public String createNewMaterial(@RequestParam String name, @RequestParam String type, @RequestParam String color){
        int res = service.createMaterial(name,type,color);
        if(res == 1){
            return "Todo ok.";
        } else {
            return "Cagaste fiera.";
        }
    }

    @GetMapping("/all")
    public List<Materials> getAllMaterials(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Materials getById(int id){
        return service.findById(id);
    }
}
