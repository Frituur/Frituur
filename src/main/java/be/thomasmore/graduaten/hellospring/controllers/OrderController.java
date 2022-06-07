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

    //TODO: When the user wants to order the product give him summary of the chosen products
    //TODO: Calculate the total order of the products for the order
    //TODO: User should be able to Change products from owner
    //TODO: Opslaan van Customer in Database for data contact
    //TODO: Count the products in order


    // TODO: aanmaken van een paar in memory objects voor producten en categorieen
    // TOOD:  Dan kunnen kiezen van een product via



    /*
    product aanpassen:
    Hij kan op dezelfde pagina producten verwijderen uit de lijst
    Toevoegen aan lijst terug sturen naar hooftmenu waar hij zijn items kan bijvullen
    Temporary in memory houden

     */
    @Autowired
    private final OrderService service;

    public OrderController(OrderService orderService) {
        service = orderService;

    }

    public String FinalOrder(){
        // Eenmaal als tijdslot gekozen is, lijst van producten in orders, naam van klant en telefoon nummer
        // Dan kan hij de final bestelling uitvoeren

        return "/complete";
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
