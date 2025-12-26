package exhodus.demo.repositories;

import exhodus.demo.model.Images;
import exhodus.demo.model.Materials;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ImageRespository extends CrudRepository<Images, Integer> {

}
