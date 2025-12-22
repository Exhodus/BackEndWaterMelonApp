package exhodus.demo.services;

import exhodus.demo.model.Users;
import exhodus.demo.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public int addNewUser(String nom, String mail, String pass){
        return userRepository.addNewUser(nom,mail,pass);
    }

    public Users findById (int id) {
        return userRepository.findById(id).get();
    }

    public Users authUser(String nom, String pass){
        Optional<Users> userOpt = userRepository.authUser(nom, pass);

        System.err.println("EN SERVICE USER: "+userOpt.get().get_userName());
        return userOpt.orElse(null);
    }
}
