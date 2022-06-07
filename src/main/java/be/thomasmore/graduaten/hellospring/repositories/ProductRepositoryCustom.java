package be.thomasmore.graduaten.hellospring.repositories;

import be.thomasmore.graduaten.hellospring.entities.Product;

import java.util.List;
import java.util.Optional;


public interface ProductRepositoryCustom {
    List<Product> RetrieveProductsByCategory(String Category);
}
