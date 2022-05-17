package be.thomasmore.graduaten.hellospring.controllers;

import be.thomasmore.graduaten.hellospring.repositories.OrderRespository;
import be.thomasmore.graduaten.hellospring.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class OrderController {

    @Autowired
    private final OrderService service;

    public OrderController(OrderService orderService) {
        service = orderService;

    }

    @GetMapping("/temporaryorder")
    public String MakeTemporaryOrder(){

        return "temporaryorder";
    }


    //Orders ophalen van de customers in database
    @GetMapping("/getorders")
    public String GetOrdersFromCustomers() {
        // get the orders from the customers
        return "getorders";
    }
}
