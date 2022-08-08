package be.thomasmore.graduaten.hellospring.dto;

import be.thomasmore.graduaten.hellospring.entities.Customer;
import be.thomasmore.graduaten.hellospring.entities.Product;
import be.thomasmore.graduaten.hellospring.entities.Timeslot;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Long id;


    private int numberOfProducts;


    private double totalPrice;



    private CustomerDto Customer;

    private TijdslotDto timeslot;

    private List<ProductDto> Product;

}
