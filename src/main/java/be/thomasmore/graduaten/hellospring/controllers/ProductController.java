package be.thomasmore.graduaten.hellospring.controllers;

import be.thomasmore.graduaten.hellospring.entities.Products;
import be.thomasmore.graduaten.hellospring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Qualifier("ProductRepository")
    @Autowired
    private ProductRepository repository;

    public ProductController(@Qualifier("ProductRepository") ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products")
    List<Products> all() {
        return repository.findAll();
    }
}

