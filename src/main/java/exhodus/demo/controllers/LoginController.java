package exhodus.demo.controllers;

import exhodus.demo.model.Users;
import exhodus.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    public static class LoginRequest {
        public String userName;
        public String pass;
    }

    public static class LoginResponse {
        public int id;
        public String userName;
        public String mail;

        public LoginResponse(Users user){
            this.id = user.get_id();
            this.userName = user.get_userName();
            this.mail = user.get_mail();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        Users user = userService.authUser(request.userName, request.pass);

        if( user == null ){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }

        return ResponseEntity.ok(new LoginResponse(user));
    }
}
