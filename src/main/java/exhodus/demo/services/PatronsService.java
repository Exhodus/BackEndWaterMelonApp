package exhodus.demo.services;

import exhodus.demo.model.Patrons;
import exhodus.demo.repositories.PatronsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatronsService {
    @Autowired
    PatronsRepository patronsRepository;

    public int createPatron(String name, String desc, int diff, int time, int user){
        System.err.println(name + " "+ desc + " "+ diff +" "+ time+" "+user );
        return patronsRepository.createPatron(name, desc, diff, time, user);
    }

    public List<Patrons> getPatronsByUserId(int id){
        List<Patrons> lista = patronsRepository.getAllPatronsByUserId(id);
        System.err.println(lista);
        return lista;
    }
}
