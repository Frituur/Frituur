package be.thomasmore.graduaten.hellospring.dto;

import be.thomasmore.graduaten.hellospring.entities.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
public class CategoryDto {

    private Long id;

    private String name;


    private List<ProductDto> product;
}
