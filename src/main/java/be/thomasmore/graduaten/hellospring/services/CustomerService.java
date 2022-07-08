package be.thomasmore.graduaten.hellospring.services;

import be.thomasmore.graduaten.hellospring.entities.Customer;
import be.thomasmore.graduaten.hellospring.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class CustomerService {

    // Make a new Customer
    @Autowired
    private CustomerRepository customerRepository;

    public boolean AddCustomer(Customer customer) {

        try{
            customerRepository.save(customer);
            return true;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }

    }

}
