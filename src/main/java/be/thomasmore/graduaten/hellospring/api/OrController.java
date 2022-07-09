package be.thomasmore.graduaten.hellospring.api;


import be.thomasmore.graduaten.hellospring.entities.Customer;
import be.thomasmore.graduaten.hellospring.entities.Orders;
import be.thomasmore.graduaten.hellospring.entities.Product;
import be.thomasmore.graduaten.hellospring.entities.Timeslot;
import be.thomasmore.graduaten.hellospring.logging.ConsoleLogger;
import be.thomasmore.graduaten.hellospring.repositories.CustomerRepository;
import be.thomasmore.graduaten.hellospring.repositories.OrderRespository;
import be.thomasmore.graduaten.hellospring.repositories.ProductRepository;
import be.thomasmore.graduaten.hellospring.services.CustomerService;
import be.thomasmore.graduaten.hellospring.services.OrderService;
import be.thomasmore.graduaten.hellospring.services.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.Order;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/orders")
@Component
public class OrController {



    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TimeslotService timeslotService;

    @Autowired
    private ConsoleLogger consoleLogger;

    @PostMapping("/neworder")
    @ResponseBody
    public ResponseEntity<String> MakeOrderWithProducts(Orders orders,
                                                        List<Integer> productsids,
                                                        Customer customer, Timeslot tijdslot){

        // Haal de tijdslot uit de database en check of deze beschikbaar is en bestaat

        List<Product>productsForOrder = new ArrayList<>();
        try{

            customerService.AddCustomer(customer);
            productsForOrder = orderService.GetAllProductsForOrder(productsids);
            orders.setTimeslot(tijdslot);
            orders.setCustomer(customer);
            orders.setProduct(productsForOrder);
            return new ResponseEntity<>("De order is toegevoegd", HttpStatus.ACCEPTED);
        }catch (Exception ex) {
            consoleLogger.PrintMessage(ex.getMessage());
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
