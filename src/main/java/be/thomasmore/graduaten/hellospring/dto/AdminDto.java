package be.thomasmore.graduaten.hellospring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminDto {


    private Long id;

    private String name;


    private List<ProductDto> product;
}
