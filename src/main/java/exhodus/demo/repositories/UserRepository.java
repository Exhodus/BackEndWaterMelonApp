package exhodus.demo.repositories;


import exhodus.demo.model.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;


public interface UserRepository extends CrudRepository<Users, Integer> {


    @Query(value = """
            SELECT u.*
            FROM users u
            WHERE u.user_name = :name AND u.pass = :pass
            """, nativeQuery = true)
    Optional<Users> authUser(String name, String pass);

    @Modifying
    @Transactional
    @Query(value = """
            INSERT INTO users (mail, pass, user_name)
            values (:mail, :pass, :nom)
            """, nativeQuery = true)
    int addNewUser(String nom, String mail, String pass);
}
