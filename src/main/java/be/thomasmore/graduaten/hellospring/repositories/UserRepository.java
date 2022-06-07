package be.thomasmore.graduaten.hellospring.repositories;


import be.thomasmore.graduaten.hellospring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Component("UserRepository")
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByUsernameOrEmail(String username, String email);
    Optional<User> findUserByEmail(String Email);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}