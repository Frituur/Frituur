package be.thomasmore.graduaten.hellospring.controllers;

import be.thomasmore.graduaten.hellospring.repositories.OrderRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private final OrderRespository orderRespository;

    public OrderController(@Qualifier("OrderRepository") OrderRespository orderRespository1) {
        this.orderRespository = orderRespository1;

    }
}
