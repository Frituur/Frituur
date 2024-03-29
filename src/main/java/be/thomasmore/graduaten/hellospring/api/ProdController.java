package be.thomasmore.graduaten.hellospring.api;

import be.thomasmore.graduaten.hellospring.entities.Category;
import be.thomasmore.graduaten.hellospring.entities.Product;
import be.thomasmore.graduaten.hellospring.logging.ConsoleLogger;
import be.thomasmore.graduaten.hellospring.repositories.CategoryRepository;
import be.thomasmore.graduaten.hellospring.repositories.ProductRepository;
import com.sun.istack.NotNull;
import com.sun.source.tree.CaseTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/products")
public class ProdController {

    @Autowired
    private ConsoleLogger consoleLogger;

    @Autowired
    private CategoryRepository categoryRepository;

    @Qualifier("ProductRepository")
    @Autowired
    private ProductRepository repository;

    @GetMapping("/products")
    List<Product> all() {

        var products = repository.findAll();
        for (Product product : products) {
            System.out.println(product.getName());
        }
        return products;
    }

    @PostMapping("/newproduct")
    @ResponseBody
    private String addProduct(@NotNull Product newProduct){
        try{
            repository.save(newProduct);
            return "nieuw product is toegevoegd";

        }catch (Exception ex){

        //"Product couldn't be signed");
            //System.out.println(ex.getMessage());
        }
        return "Niet gelukt om een product te kunnen toevoegen";
    }




}

