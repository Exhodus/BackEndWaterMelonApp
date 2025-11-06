package exhodus.demo.services;

import exhodus.demo.enums.MaterialTypes;
import exhodus.demo.model.Materials;
import exhodus.demo.repositories.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MaterialService {
    @Autowired
    MaterialRepository materialRepository;

    public List<Materials> findAll(){
        Iterable<Materials> materials = materialRepository.findAll();
        List<Materials> lista = new ArrayList<>();
        for(Materials material : materials){
            lista.add(material);
        }
        return lista;
    }

    public Materials findById(int id){
        return materialRepository.findById(id).get();
    }

    public int createMaterial(String name, String type, String color){
        MaterialTypes materialType = MaterialTypes.valueOf(type.toUpperCase());
        int numType = 0;

        //THREAD, HOOK, ACCESSORY, CLIP
        switch (materialType){
            case MaterialTypes.THREAD:
                numType = 1;
                break;
            case MaterialTypes.HOOK:
                numType = 2;
                break;
            case MaterialTypes.ACCESSORY:
                numType = 3;
                break;
            default:
                numType = 4;
                break;
        }

        return materialRepository.createMaterial(name, numType, color);
    }
}
