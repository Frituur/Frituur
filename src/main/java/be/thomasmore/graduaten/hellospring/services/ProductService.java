package be.thomasmore.graduaten.hellospring.services;

import be.thomasmore.graduaten.hellospring.entities.Categories;
import be.thomasmore.graduaten.hellospring.entities.Products;
import be.thomasmore.graduaten.hellospring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@Component
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    protected Products GetProductById(int id) {
        return null;
    }

    protected List<Products> GetProductsByCatorgory(Categories categories) {
        //return all the products based on catory
        //return productRepository.getProductsByCategory(categories);
        return null;
    }


    //For when the user wants to search at a specific set of products
    protected List<Products> GetProductsBySearchName(String productName){

        String productNameWithoutUpperCaseAndSpaces = productName.toLowerCase(Locale.ROOT).trim();
        List<Products> AllProducts = productRepository.findAll();
        List<Products> SearchedProducts = new ArrayList();


        for (Products product : AllProducts) {
            if(product.getName().contentEquals(productNameWithoutUpperCaseAndSpaces)){
                SearchedProducts.add(product);
            }
        }

        return SearchedProducts;




    }
    
    protected List<Products> GetAllProducts() {
        return productRepository.findAll();
    }

    /*
    protected List<Products> GetProductsByCategory(Categories Category) {

        return productRepository.getProductsByCategory(Category);


    }

     */
}
