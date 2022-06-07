package be.thomasmore.graduaten.hellospring.api;


import be.thomasmore.graduaten.hellospring.entities.Customer;
import be.thomasmore.graduaten.hellospring.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustController {

    @Qualifier("CustomerRepository")
    @Autowired
    private CustomerRepository repository;

    public CustController(@Qualifier("CustomerRepository") CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/customers")
    List<Customer> all() {
        return repository.findAll();
    }
}
