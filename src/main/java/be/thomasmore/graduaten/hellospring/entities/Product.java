package be.thomasmore.graduaten.hellospring.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int quantity;
    private boolean availability;

    @OneToOne
    private Category category;

    @ManyToOne
    private Order order;

    @ManyToMany
    private List<Extra> extras;

    public Product() {
    }

    public Product(Long id, String name, String description, boolean availability, Category category, Order order, List<Extra> extras, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.availability = availability;
        this.category = category;
        this.order = order;
        this.quantity = quantity;
        this.extras = extras;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void SetQuantity(int quantity) { this.quantity = quantity;}

    public int GetQuantity() {return this.quantity;}

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Extra> getExtras() {
        return extras;
    }

    public void setExtras(List<Extra> extras) {
        this.extras = extras;
    }
}
