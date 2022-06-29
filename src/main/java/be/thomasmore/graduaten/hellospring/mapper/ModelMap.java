package be.thomasmore.graduaten.hellospring.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ModelMap {

    public ModelMapper  modelMapper(){
        return new ModelMapper();
    }
}
