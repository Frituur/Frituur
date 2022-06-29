package be.thomasmore.graduaten.hellospring.api;

import be.thomasmore.graduaten.hellospring.dto.CustomerDto;
import be.thomasmore.graduaten.hellospring.entities.Category;
import be.thomasmore.graduaten.hellospring.entities.Customer;
import be.thomasmore.graduaten.hellospring.mapper.ModelMap;
import be.thomasmore.graduaten.hellospring.repositories.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/customer")
public class CusController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMap modelMap;


    @GetMapping("/customers")
    List<Customer> all() {
        return customerRepository.findAll();

    }

    @PostMapping("/newcustomer")
    ResponseEntity<String> add(@Valid CustomerDto customerDto, BindingResult result) {
        try{
            if(result.hasErrors()){
                Customer customer = modelMap.modelMapper().map(customerDto, Customer.class);
                customerRepository.save(customer);
                return new ResponseEntity<>("De klant is toegevoegd", HttpStatus.ACCEPTED);
            }

            return new ResponseEntity<>("Er waren errors in klant", HttpStatus.BAD_REQUEST);

        }catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }




}
