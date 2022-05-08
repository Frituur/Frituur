package be.thomasmore.graduaten.hellospring.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numberOfProducts;
    private double totalPrice;
    private Status orderStatus;
    private String address;

    private OrderType orderType;


    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer Customer;

    @OneToOne
    private Timeslot timeslot_id;

    @CollectionTable(name = "Product", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "Products")
    @OneToMany( targetEntity= be.thomasmore.graduaten.hellospring.entities.Products.class)
    private List Products;

    public Orders(Long id, int numberOfProducts, double totalPrice, Status orderStatus, String address, be.thomasmore.graduaten.hellospring.entities.Customer customer, Timeslot timeslot_id, List products) {
        this.id = id;
        this.numberOfProducts = numberOfProducts;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
        Customer = customer;
        this.timeslot_id = timeslot_id;
        Products = products;
    }

    public Orders() {

    }

    public be.thomasmore.graduaten.hellospring.entities.Customer getCustomer() {
        return Customer;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public void setNumberOfProducts(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Status getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Status orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCustomer(be.thomasmore.graduaten.hellospring.entities.Customer customer) {
        Customer = customer;
    }

    public Timeslot getTimeslot_id() {
        return timeslot_id;
    }

    public void setTimeslot_id(Timeslot timeslot_id) {
        this.timeslot_id = timeslot_id;
    }

    public List getProducts() {
        return Products;
    }

    public void setProducts(List products) {
        Products = products;
    }
}
