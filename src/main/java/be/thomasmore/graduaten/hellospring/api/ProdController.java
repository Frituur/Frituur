package be.thomasmore.graduaten.hellospring.api;

import be.thomasmore.graduaten.hellospring.entities.Category;
import be.thomasmore.graduaten.hellospring.entities.Product;
import be.thomasmore.graduaten.hellospring.repositories.CategoryRepository;
import be.thomasmore.graduaten.hellospring.repositories.ProductRepository;
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
    private String addProduct(Product newProduct){
        try{
            repository.save(newProduct);
            return "nieuw product is toegevoegd";

        }catch (Exception ex){
            System.out.println("Product couldn't be signed");
            System.out.println(ex.getMessage());
        }
        return "Niet gelukt om een product te kunnen toevoegen";
    }

    @PostMapping("/productcategory")
    @ResponseBody
    private String addProductWithCategory(Product newProduct, Long categoryid){
        try{
            var category = categoryRepository.getById(categoryid);
            System.out.println(category.getName());
            List<Category> CategoryForNewProduct = new ArrayList<>();
            CategoryForNewProduct.add(category);
            newProduct.setCategory(CategoryForNewProduct);
            repository.save(newProduct);
            return "nieuw product met een categorie is toegevoegd";
        }
        catch (Exception ex) {
            System.out.println("Product kan niet worden toegevoegd");
            System.out.println(ex.getMessage());
        }
        return "Niet gelukt om een product te kunnen toevoegen";
    }
}

