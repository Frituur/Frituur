package be.thomasmore.graduaten.hellospring.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Extra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Float price;

    private String Description;

    @ManyToMany
    private List<Product> Product;

    public Extra(Long id, String name, Float price, String description, List<be.thomasmore.graduaten.hellospring.entities.Product> product) {
        this.id = id;
        this.name = name;
        this.price = price;
        Description = description;
        Product = product;
    }

    public Extra() {

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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public List<be.thomasmore.graduaten.hellospring.entities.Product> getProduct() {
        return Product;
    }

    public void setProduct(List<be.thomasmore.graduaten.hellospring.entities.Product> product) {
        Product = product;
    }
}