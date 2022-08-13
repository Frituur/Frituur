package be.thomasmore.graduaten.hellospring.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid")
    private Long id;

    @Column(name = "numberofproducts")
    private int numberOfProducts;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="customerid")
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Timeslot timeslot;

    @OneToOne
    @JoinColumn(name="productid")
    private Product product;


}
