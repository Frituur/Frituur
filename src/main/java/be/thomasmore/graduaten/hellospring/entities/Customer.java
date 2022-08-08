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

    @Column(name = "firstname")
    private String firstname ;


    @Column(name = "lastname")
    private String lastname ;


    private String address;

    @OneToMany(mappedBy = "customer")
    private List<Orders> orders;


}
