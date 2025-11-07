package exhodus.demo.repositories;

import exhodus.demo.model.Patrons;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatronsRepository extends CrudRepository<Patrons, Integer> {

    @Modifying
    @Transactional
    @Query(value= """
            INSERT INTO patrons (patron_name, description, difficulty, estimated_time, user_id)
            VALUES (:name, :desc, :diff, :time, :user)
            """, nativeQuery = true)
    int createPatron(String name, String desc, int diff, int time, int user);

    @Query(value = """
            SELECT p.*
            FROM patrons p
            WHERE user_id = :id
            """, nativeQuery = true)
    List<Patrons> getAllPatronsByUserId(int id);


    @Query(value = """
            UPDATE patrons p
            SET p.patron_name = :name,
                p.description = :desc,
                p.difficulty = :diff,
                p.estimated_time = :time,
                p._user_id = :userId
            WHERE p.id = :id
            """, nativeQuery = true)
    int updatePatron(int id, String name, String desc, int diff, int time, int userId);
}
