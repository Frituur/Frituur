package be.thomasmore.graduaten.hellospring.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    @NotBlank(message = "Firstname is mandatory")
    @Column(name = "firstname")
    private String firstname ;

    @NotBlank(message = "Lastname is mandatory")
    @Column(name = "lastname")
    private String lastname ;

    @NotBlank(message = "Address  is mandatory")
    private String address;
    private String phone;
    private String email;

    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private List<Orders> Order;


}
