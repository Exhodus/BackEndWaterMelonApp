package exhodus.demo.services;

import exhodus.demo.DTOS.PatronSimpleDTO;
import exhodus.demo.enums.Difficulty;
import exhodus.demo.model.Patrons;
import exhodus.demo.repositories.PatronsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatronsService {
    @Autowired
    PatronsRepository patronsRepository;

    public ResponseEntity<?> createPatron(String name, String desc, int diff, int time, int user){

        System.err.println("DESCRIPCION EN SERVICE: "+desc);

        int filas = patronsRepository.createPatron(name, desc, diff, time, user);

        if (filas > 0) {
            return ResponseEntity.ok("Patrón creado");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("No se insertó ningún registro");
        }
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
