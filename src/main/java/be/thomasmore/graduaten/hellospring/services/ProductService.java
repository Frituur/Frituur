package be.thomasmore.graduaten.hellospring.services;

import be.thomasmore.graduaten.hellospring.entities.Products;
import be.thomasmore.graduaten.hellospring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    protected Products GetProductById(int id) {
        return null;
    }

    protected List<Products> GetProductsByCatorgory() {
        //return all the products based on catory
        return null;
    }



}
