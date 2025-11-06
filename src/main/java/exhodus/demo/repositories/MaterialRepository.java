package exhodus.demo.repositories;

import exhodus.demo.model.Materials;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MaterialRepository extends CrudRepository<Materials, Integer> {

    @Modifying
    @Transactional
    @Query(value = """
            INSERT INTO materials (material_name, material_tipe, color)
            VALUES (:name, :type, :color)
            """, nativeQuery = true)
    public int createMaterial(String name, int type, String color);


}
