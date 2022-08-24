package be.thomasmore.graduaten.hellospring.controllers;

import be.thomasmore.graduaten.hellospring.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes({"Product"})
public class ProductController {

    //TODO: Maken van een session voor opslaan van lijst producten voor de customer
    //TODO: Need to search for a products when the user enters a category name
    // TODO: Need to send products to screen based on categories
    // TODO: When the user post that he wants that product  store in session
    // TODO: Convert the Image to base64string to display on the screen
    //TODO: Tonen van een bepaald product detail pagina door id



    @RequestMapping(value = "/product", method= RequestMethod.GET)
    public String showProductPage(@RequestParam String name, ModelMap map){

        return "product";
    }

    @RequestMapping(value = "storeproduct", method = RequestMethod.POST)
    public String storeProductCustomerForOrder(@Valid Product product, BindingResult bindingResult
                                               ){
        return "Detail";
    }

/*    @RestController
    @RequestMapping*/






    //Add new product


}
