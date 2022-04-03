package be.thomasmore.graduaten.hellospring.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Owner")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String password;

    @OneToOne
    private Shop shop;


    @CollectionTable(name = "Orders", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "Orders")
    @OneToMany( targetEntity=Order.class)
    private List Orders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
