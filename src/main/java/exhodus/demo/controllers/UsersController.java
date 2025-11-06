package exhodus.demo.controllers;

import exhodus.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UserService service;


    @GetMapping("/hola")
    public @ResponseBody String test(){
        return "hola";
    }

    @GetMapping("/create")
    public  String addNewUser(@RequestParam String nom, @RequestParam String mail, @RequestParam String pass){
        int res = service.addNewUser(nom,mail,pass);
        if(res == 1){
            return "Todo ok.";
        } else {
            return "Error.";
        }
    }

}
