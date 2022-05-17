package be.thomasmore.graduaten.hellospring.repositories;

import be.thomasmore.graduaten.hellospring.entities.Categories;
import be.thomasmore.graduaten.hellospring.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component("CategoryRepository")
@Repository
public interface CategoryRepository extends JpaRepository<Categories, Long> {
}