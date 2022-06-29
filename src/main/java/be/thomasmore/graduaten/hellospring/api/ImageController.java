package be.thomasmore.graduaten.hellospring.api;

import be.thomasmore.graduaten.hellospring.entities.Product;
import be.thomasmore.graduaten.hellospring.repositories.ProductRepository;
import be.thomasmore.graduaten.hellospring.shared.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.constraints.NotNull;
import java.util.Locale;

@RestController
@RequestMapping("/api/image")
public class ImageController {

    @Autowired
    private Converter converter;

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/{productname}", method = RequestMethod.GET)
    @ResponseBody
    public String GetImageFromGivenProduct(@PathVariable @NotNull String productname){
         //Test if you get the a product image by searching in the name
         String stringImage = null;
         var products  = productRepository.findAll();
         for (Product product : products) {
             String productByNameInDb = product.getName().toLowerCase(Locale.ROOT);
             if(productByNameInDb.contains(productname)){
                 stringImage = converter.ConvertByteArrayToBase64(product.getPhoto());
             }

         }
         return stringImage;
     }
    // Try to convert convert the image from Byte array to Base64

}
