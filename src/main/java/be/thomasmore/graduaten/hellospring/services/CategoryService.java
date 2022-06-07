package be.thomasmore.graduaten.hellospring.services;

import be.thomasmore.graduaten.hellospring.entities.Category;
import be.thomasmore.graduaten.hellospring.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class CategoryService {


    @Autowired
    private CategoryRepository categoryRepository;


    protected Category GetSpecificCatgoryById(long id){

        return categoryRepository.getById(id);
    }

    protected List<Category> GetAllCategories() {
        return categoryRepository.findAll();
    }



}
