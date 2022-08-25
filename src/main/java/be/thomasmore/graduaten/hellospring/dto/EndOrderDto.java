package be.thomasmore.graduaten.hellospring.dto;

import be.thomasmore.graduaten.hellospring.entities.Customer;
import be.thomasmore.graduaten.hellospring.entities.Timeslot;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Data
public class EndOrderDto {

    public List<ProductDto> productDtos;

    public double TotalPrice;

    public String customerName;

    public String customerAddress;

    public List<Timeslot> timeslots;

    public LocalDate Today;

}
