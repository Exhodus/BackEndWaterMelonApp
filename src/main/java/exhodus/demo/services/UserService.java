package exhodus.demo.services;

import exhodus.demo.model.Users;
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

    public Users findById (int id) {
        return userRepository.findById(id).get();
    }
}
