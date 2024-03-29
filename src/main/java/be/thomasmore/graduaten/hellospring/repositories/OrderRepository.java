package be.thomasmore.graduaten.hellospring.repositories;

import be.thomasmore.graduaten.hellospring.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component("OrderRepository")
@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

}


