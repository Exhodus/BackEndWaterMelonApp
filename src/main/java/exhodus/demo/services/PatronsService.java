package exhodus.demo.services;

import exhodus.demo.DTOS.PatronSimpleDTO;
import exhodus.demo.enums.Difficulty;
import exhodus.demo.model.Patrons;
import exhodus.demo.model.Users;
import exhodus.demo.repositories.PatronsRepository;
import exhodus.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatronsService {
    @Autowired
    PatronsRepository patronsRepository;
    @Autowired
    UserRepository userRepository;

    public Patrons createPatron(String name, String desc, String diff, int time, int user){

        System.err.println("DESCRIPCION EN SERVICE: "+desc);

        Optional<Users> usuario = userRepository.findById(user);

        if(usuario != null) {
            Patrons patron = new Patrons();
            patron.set_patronName(name);
            patron.set_patronUser(usuario.get());
            patron.set_description(desc);
            patron.set_difficulty(Difficulty.valueOf(diff));
            patron.set_estimatedTime(time);
            return patronsRepository.save(patron);
        }

        return null;
    }

    public List<PatronSimpleDTO> getPatronsByUserId(int id){
        List<PatronSimpleDTO> lista = patronsRepository.getAllPatronsByUserId(id);
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

        return patronsRepository.updatePatron(
                patron.getId(),
                patron.get_patronName(),
                patron.get_description(),
                diff,
                patron.get_estimatedTime(),
                patron.get_patronUser().get_id()
        );
    }

}
