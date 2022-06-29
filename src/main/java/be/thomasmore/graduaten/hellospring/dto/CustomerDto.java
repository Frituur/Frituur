package be.thomasmore.graduaten.hellospring.dto;

import be.thomasmore.graduaten.hellospring.entities.Orders;
import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import java.util.List;

@Data
public class CustomerDto {

    @NotNull( message = "Firstname can't be null")
    @Column(name = "firstname")
    private String firstname ;

    @NotNull( message = "Firstname can't be null")
    @Column(name = "lastname")
    private String lastname ;

    private String fullname = firstname + lastname;

    private String address;
    private String phone;
    private String email;


}
