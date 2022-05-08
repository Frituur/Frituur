package be.thomasmore.graduaten.hellospring.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "Products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    private Long id;

    @Column(name = "productname")
    private String name;


    @Column(name = "price")
    private int price;

    @Column(name = "availability")
    private boolean availability;

    @Column(name = "photo")
    private byte[] photo;


    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "categoryid",referencedColumnName = "productid")
    private Categories categoryid;

    @ManyToOne
    @JoinColumn(name = "orderid")
    private Orders order;


    public Products() {
    }

    public Products(Long id, String name, boolean availability, byte[] photo, Categories categoryid, Orders order, int price) {
        this.id = id;
        this.name = name;
        this.availability = availability;
        this.photo = photo;
        this.categoryid = categoryid;
        this.order = order;
        this.price = price;

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


    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void SetPrice(int price) { this.price = price;}

    public int GetPrice() {return this.price;}

    public Categories getCategory() {
        return categoryid;
    }

    public void setCategory(Categories categoryid) {
        this.categoryid = categoryid;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }


}
