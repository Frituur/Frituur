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

    @Column(name="totalprice")
    private double totalPrice;



    @ManyToOne
    @JoinTable(name = "Customers",
            joinColumns = {@JoinColumn(name="orderid")},
            inverseJoinColumns = @JoinColumn(name = "customerid"))
    private Customer Customer;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Timeslot timeslot;

    @OneToMany(mappedBy= "orderid")
    @JsonManagedReference
    private List<Product> Product;


}
