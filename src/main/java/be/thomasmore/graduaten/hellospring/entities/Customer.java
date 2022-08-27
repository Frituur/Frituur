package be.thomasmore.graduaten.hellospring.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerid")
    private Long id;

    @Column(name = "naam")
    private String naam;

    @Column(name="address")
    private String address;

    @Column(name= "totalprice")
    private Double totalprice;

    @OneToMany(mappedBy = "customer")
    private List<Orders> orders;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tijdslotid")
    private Timeslot timeslot;

}
