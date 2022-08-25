package be.thomasmore.graduaten.hellospring.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

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

    @OneToOne(mappedBy = "timeslot")
    private Orders Order;


}
