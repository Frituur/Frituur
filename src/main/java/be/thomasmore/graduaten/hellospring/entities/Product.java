package be.thomasmore.graduaten.hellospring.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    private Long id;

    @Column(name = "productname")
    private String name;


    @Column(name = "price")
    private Double price;

    @Column(name = "availability")
    private boolean availability;

    @Column(name = "photo")
    private byte[] photo;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="categoryid")
    private Category category;








}
