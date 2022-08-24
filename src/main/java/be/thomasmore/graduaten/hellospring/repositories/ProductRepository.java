package be.thomasmore.graduaten.hellospring.repositories;

import be.thomasmore.graduaten.hellospring.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component("ProductRepository")
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%")
    public List<Product> search(String keyword);

}


