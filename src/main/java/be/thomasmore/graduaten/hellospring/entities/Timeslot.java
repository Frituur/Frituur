package be.thomasmore.graduaten.hellospring.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name ="Tijdslot")
public class Timeslot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Timestamp timeArrival;

    private Boolean isAvailable = true;

    @OneToOne(mappedBy = "timeslot", fetch = FetchType.LAZY)
    private Orders Order;

    public Timeslot() {

    }

    public Timeslot(Timestamp timestamp, Orders order, boolean isAvailable ) {
        timeArrival = timestamp;
        Order = order;
        this.isAvailable = isAvailable;

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

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
}
