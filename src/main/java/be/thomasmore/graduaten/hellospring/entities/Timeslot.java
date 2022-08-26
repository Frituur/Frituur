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
@Table(name ="tijdslot")
public class Timeslot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "begintime")
    private String begintime;

    @Column(name = "isavailable")
    private Boolean isAvailable = true;

    @Column(name="numcustomers")
    private Long numcustomers;


    @Column(name="maxcustomers")
    private Long  maxcustomers;



    @OneToMany(mappedBy = "timeslot")
    private List<Customer> customer;


}
