package be.thomasmore.graduaten.hellospring.Shared;

import be.thomasmore.graduaten.hellospring.repositories.CustomerRepository;
import be.thomasmore.graduaten.hellospring.repositories.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    // Datbase vullen

    public void CommandLineRunner(ProductRepository productRepository) {
        // making several new products


    }

}
