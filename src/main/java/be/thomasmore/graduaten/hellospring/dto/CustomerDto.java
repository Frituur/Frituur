package be.thomasmore.graduaten.hellospring.dto;

import be.thomasmore.graduaten.hellospring.entities.Orders;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {

    private String firstname ;

    private String lastname ;

    private String fullname = firstname + lastname;

    private String address;
    private String phone;
    private String email;


}
