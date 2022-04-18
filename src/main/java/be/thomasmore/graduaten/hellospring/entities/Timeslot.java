package be.thomasmore.graduaten.hellospring.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Timeslot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Timestamp timeArrival;

    @OneToOne
    private Product product;

    public Timeslot() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTimeArrival(Timestamp timeArrival) {
        this.timeArrival = timeArrival;
    }

    public Long getId() {
        return id;
    }

    public Timestamp getTimeArrival() {
        return timeArrival;
    }
}
