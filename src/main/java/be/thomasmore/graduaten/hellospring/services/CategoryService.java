package be.thomasmore.graduaten.hellospring.services;

import be.thomasmore.graduaten.hellospring.entities.Categories;
import be.thomasmore.graduaten.hellospring.repositories.CategoryRepository;
import be.thomasmore.graduaten.hellospring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Component
@Service
public class CategoryService {


    @Autowired
    private CategoryRepository categoryRepository;


    protected Categories GetSpecificCatgoryById(long id){
        return categoryRepository.getById(id);
    }


}
