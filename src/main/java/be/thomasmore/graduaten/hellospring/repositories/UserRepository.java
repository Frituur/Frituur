package be.thomasmore.graduaten.hellospring.repositories;


import be.thomasmore.graduaten.hellospring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String Email);
}