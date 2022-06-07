package be.thomasmore.graduaten.hellospring.api;

import be.thomasmore.graduaten.hellospring.entities.Category;
import be.thomasmore.graduaten.hellospring.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class CateController {

    @Autowired
    private CategoryService categoryService;

    public CateController(CategoryService categoryService) {
        categoryService = categoryService;
    }

    @GetMapping("/categories")
    List<Category> all() {
        return null;

    }
}
