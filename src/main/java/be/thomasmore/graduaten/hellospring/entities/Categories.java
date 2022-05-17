package be.thomasmore.graduaten.hellospring.entities;

import javax.persistence.*;

@Entity
@Table(name = "Categories")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryid")
    private Long id;

    @Column(name = "categoryname")
    private String name;


    @OneToOne(mappedBy="categoryid", orphanRemoval = true ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Products product;

    public Categories(Long id, String name, Products product) {
        this.id = id;
        this.name = name;
        this.product = product;
    }

    public Categories() {

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


    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }



}
