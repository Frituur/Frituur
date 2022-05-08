package be.thomasmore.graduaten.hellospring.services;

import be.thomasmore.graduaten.hellospring.entities.Customer;
import be.thomasmore.graduaten.hellospring.entities.Orders;
import be.thomasmore.graduaten.hellospring.entities.OrderType;
import be.thomasmore.graduaten.hellospring.entities.Products;
import be.thomasmore.graduaten.hellospring.repositories.CustomerRepository;
import be.thomasmore.graduaten.hellospring.repositories.OrderRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class OrderService {
    // Customers should be able to make orders
    // Need dependency injection for repositories and services

    @Qualifier("OrderRepository")
    @Autowired
    private OrderRespository OrderRespository;

    @Autowired
    private CustomerRepository CustomerRepository;

    // A customer chosen products
    // We need to make that order based on the products linked to
    public void MakeOrder(List<Products> CustomerProducts, Customer customer) {
        Orders order = new Orders();
        // Set the status of the order to preparing
        // Based on Order type send an automatic message or message the customer itself
        // timeslot of the order
        // Check if it's a big order or not
        // Start a deamon once the order has been made

    }

    private double CalculateTotalPrice(List<Products> CustomerProducts){
        // Go through the list of  products
        // Get the price for of each product  times the how many
        // add every price up
        // return the total price

        return 0;
    }

    //
    public OrderType DetermineOrderType(List<Products> Products) {
        int numberOfProducts = 0;
        for(int i = 0; i < Products.stream().count(); i++) {
            numberOfProducts += 1;
        }

        if(numberOfProducts > 6) {
            return OrderType.Big;
        }
        return OrderType.Small;

    }

    // Let the customer know when the order is ready
    // This is a chosen value or

    // Send on automatic response to the user once the order is done
    // Check the time when the order was made
    // Time slot  => Once  the datetime is reached message should be send
    //
}
