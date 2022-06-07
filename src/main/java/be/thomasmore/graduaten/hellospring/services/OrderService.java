package be.thomasmore.graduaten.hellospring.services;

import be.thomasmore.graduaten.hellospring.entities.Customer;
import be.thomasmore.graduaten.hellospring.entities.Orders;
import be.thomasmore.graduaten.hellospring.entities.Product;
import be.thomasmore.graduaten.hellospring.repositories.CustomerRepository;
import be.thomasmore.graduaten.hellospring.repositories.OrderRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    public void MakeTemporaryOrder(List<Product> customerProducts, Customer customer) {
        Orders order = new Orders();


    }

    protected double CalculateTotalPrice(Orders Order){
        // Go through the list of  products
        Double totalPrice = 0.0;
        List<Product> productCustomer = Order.getProduct();
        int quantityOfProducts = Order.getNumberOfProducts();
        // Laad the Order
        for (Product product : productCustomer) {
            totalPrice += product.getPrice() * quantityOfProducts;

        }
        return totalPrice;
    }

    //Admin moet orders kunnen zien
    protected  List<Orders> GetOrders(){
        // Filter op basis van de order die er is
        // Alle timestamp dat is later dan current time filter out
        List<Orders> OrdersNotHandled = new ArrayList<>();
        List<Orders> allOrders = OrderRespository.findAll();

        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        for (Orders order : allOrders)
        {
            if(order.getTimeslot().getTimeArrival().after(timestamp)){
                OrdersNotHandled.add(order);

            }


        }

        return OrdersNotHandled;

    }

    public boolean DeleteProductFromOrder(Orders orders, Product product) {
        // TODO: THE USER CAN DELETE PRODUCT FROM ORDER BY

        return true;
    }

    // Let the customer know when the order is ready
    // This is a chosen value or

    // Send on automatic response to the user once the order is done
    // Check the time when the order was made
    // Time slot  => Once  the datetime is reached message should be send
    //
}
