package be.thomasmore.graduaten.hellospring.api;

import be.thomasmore.graduaten.hellospring.entities.Categories;
import be.thomasmore.graduaten.hellospring.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiCategoryController {

    @Qualifier("CategoryRepository")
    @Autowired
    private CategoryRepository repository;

    public ApiCategoryController(@Qualifier("CategoryRepository") CategoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/category")
    List<Categories> all() {
        return repository.findAll();
    }
}
