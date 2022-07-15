package be.thomasmore.graduaten.hellospring.services;

import be.thomasmore.graduaten.hellospring.entities.Orders;
import be.thomasmore.graduaten.hellospring.entities.Product;
import be.thomasmore.graduaten.hellospring.repositories.CustomerRepository;
import be.thomasmore.graduaten.hellospring.repositories.OrderRepository;
import be.thomasmore.graduaten.hellospring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class OrderService {
    // Customers should be able to make orders
    // Need dependency injection for repositories and services
    @Autowired
    private ProductRepository productRepository;

    @Qualifier("OrderRepository")
    @Autowired
    private OrderRepository OrderRepository;

    @Autowired
    private CustomerRepository CustomerRepository;

    //



    public double CalculateTotalPrice(Orders Order){
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
    public  List<Orders> GetOrdersNotDoneYet(){
        // Filter op basis van de order die er is
        // Alle timestamp dat is later dan current time filter out
        List<Orders> OrdersNotHandled = new ArrayList<>();
        List<Orders> allOrders = OrderRepository.findAll();

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

    public List<Product> DeleteProductFromOrder(Orders orderCustomer, Long id) {
        // TODO: THE USER CAN DELETE PRODUCT FROM ORDER BY
        var productsCustomer = orderCustomer.getProduct();
        for(Product product : productsCustomer){
            if(product.getId() == id ){
                productsCustomer.remove(product);
            }
        }
        return productsCustomer;
    }


    // TODO:Pak alle id's van producten dat de klant geselecteerd heeft voor de bestalling
    public List<Product> GetAllProductsForOrder(List<Integer> allproductids){
        //get all the products bij looking up de ids
        var products = productRepository.findAll();
        List<Product> productForOrder = new ArrayList<>();

        for (Product product : products) {
            if(allproductids.contains(product.getId())){
                productForOrder.add(product);
            }
        }

        return productForOrder;
    }

    protected  boolean saveOrder(Orders order) {
        OrderRepository.save(order);
        return true;
    }
}
