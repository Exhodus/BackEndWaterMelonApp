package exhodus.demo.services;

import exhodus.demo.enums.Difficulty;
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

    public Patrons getPatronById(int id){
        return patronsRepository.findById(id).get();
    }

    public int updatePatrons(Patrons patron){
        int diff;

        switch (patron.get_difficulty()){
            case EASY -> diff = 1;
            case MEDUIM -> diff = 2;
            case HARD -> diff = 3;
            case null, default -> diff = 0;
        }

        return patronsRepository.updatePatron(patron.getId(), patron.get_patronName(), patron.get_description(), diff, patron.get_estimatedTime(), patron.get_userId());
    }
}
