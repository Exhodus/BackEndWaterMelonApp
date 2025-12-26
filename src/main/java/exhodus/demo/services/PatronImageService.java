package exhodus.demo.services;

import exhodus.demo.model.Images;
import exhodus.demo.model.Patrons;
import exhodus.demo.repositories.ImageRespository;
import exhodus.demo.repositories.PatronsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.Optional;

@Service
public class PatronImageService {

    @Autowired
    ImageRespository repo;
    @Autowired
    PatronsRepository repoPatron;

    public String uploadImage(String url, int idPatron, String description, String type){
        Optional<Patrons> patron = repoPatron.findById(idPatron);
        if(patron != null){
            Images imgToSave = new Images();
            imgToSave.set_idPatron(patron.get());
            imgToSave.set_url(url);
            imgToSave.set_type(type);
            repo.save(imgToSave);
            return imgToSave.get_url();
        }
        return null;
    }
}
