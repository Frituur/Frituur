package be.thomasmore.graduaten.hellospring.repositories;

import be.thomasmore.graduaten.hellospring.entities.Categories;
import be.thomasmore.graduaten.hellospring.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component("ProductRepository")
@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {


}
