package be.thomasmore.graduaten.hellospring.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid")
    private Long id;

    @Column(name = "numberofproducts")
    private int numberOfProducts;

    @Column(name="totalprice")
    private double totalPrice;



    @OneToOne(mappedBy="Order", orphanRemoval = true ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Customer Customer;

    @OneToOne
    @JoinColumn(name = "tijdslotid")
    private Timeslot timeslot;

    @OneToMany(mappedBy= "orderid",cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Products> Products;

    public Orders(Long id, int numberOfProducts, double totalPrice, String address, Customer customer,  Set<Products> products, Timeslot timeslot) {
        this.id = id;
        this.numberOfProducts = numberOfProducts;
        this.totalPrice = totalPrice;
        Customer = customer;
        Products = products;
        timeslot = timeslot;
    }

    public Orders() {

    }

    public Customer getCustomer() {
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


    public void setCustomer(Customer customer) {
        Customer = customer;
    }


    public Set<Products> getProducts() {
        return Products;
    }

    public void setProducts(Set<Products> products) {
        Products = products;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }
}
