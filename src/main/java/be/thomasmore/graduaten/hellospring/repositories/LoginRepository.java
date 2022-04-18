package be.thomasmore.graduaten.hellospring.repositories;


import be.thomasmore.graduaten.hellospring.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Owner, Long> {

}