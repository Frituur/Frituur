/*
package be.thomasmore.graduaten.hellospring.entities;
import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numberOfProducts;
    private double totalPrice;
    private Timestamp timeOfOrder;
    private Timestamp arrivalTime;
    private Status orderStatus;
    private String address;

    @CollectionTable(name = "Product", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "Products")
    private List<Product> Products;


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

    public LocalDate getTimeOfOrder() {
        return timeOfOrder;
    }

    public void setTimeOfOrder(LocalDate timeOfOrder) {
        this.timeOfOrder = timeOfOrder;
    }

    public LocalDate getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDate arrivalTime) {
        this.arrivalTime = arrivalTime;
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
}
*/