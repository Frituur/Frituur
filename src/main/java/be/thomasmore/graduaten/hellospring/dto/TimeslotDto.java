package be.thomasmore.graduaten.hellospring.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
public class TimeslotDto {

    private Long id;
    private String begintime;
    private Boolean isAvailable;
    private Long numcustomers;
    private Long  maxcustomers;

}
