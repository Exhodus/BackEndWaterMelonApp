package exhodus.demo.services;

import exhodus.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public int addNewUser(String nom, String mail, String pass){
        return userRepository.addNewUser(nom,mail,pass);
    }
}
