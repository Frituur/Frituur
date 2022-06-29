package be.thomasmore.graduaten.hellospring.services;

import be.thomasmore.graduaten.hellospring.entities.Category;
import be.thomasmore.graduaten.hellospring.entities.Product;
import be.thomasmore.graduaten.hellospring.repositories.ProductRepository;
import be.thomasmore.graduaten.hellospring.shared.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@Component
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Autowired
    private Converter converter;


    public Product GetProductById(int id) {
        return null;
    }

    public List<Product> GetProductsByCatorgory(String category) {
        //return all the products based on catory
        //var products  =  productRepository.GetProductsByCategory(category);
        return null;
    }



    //For when the user wants to search at a specific set of products
    public List<Product> GetProductsBySearchName(String productName){

        String productNameWithoutUpperCaseAndSpaces = productName.toLowerCase(Locale.ROOT).trim();
        List<Product> allProducts = productRepository.findAll();
        List<Product> searchedProducts = new ArrayList();


        for (Product product : allProducts) {
            if(product.getName().contentEquals(productNameWithoutUpperCaseAndSpaces)){
                searchedProducts.add(product);
            }
        }

        return searchedProducts;

    }

    public String GetProductImage(String productName){
        var products = productRepository.findAll();
        String productNameWithoutUpperCaseAndSpaces = productName.toLowerCase(Locale.ROOT).trim();
        for (Product product : products) {
            if(product.getName().contentEquals(productNameWithoutUpperCaseAndSpaces)){
                return converter.ConvertByteArrayToBase64(product.getPhoto());
            }
        }

        return null;
    }


    protected List<Product> GetAllProducts() {
        return productRepository.findAll();
    }

}
