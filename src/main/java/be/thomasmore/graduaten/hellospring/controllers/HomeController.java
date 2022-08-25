package be.thomasmore.graduaten.hellospring.controllers;
import be.thomasmore.graduaten.hellospring.dto.CategoryDto;
import be.thomasmore.graduaten.hellospring.dto.ProductDto;
import be.thomasmore.graduaten.hellospring.entities.Category;
import be.thomasmore.graduaten.hellospring.entities.Customer;
import be.thomasmore.graduaten.hellospring.entities.Orders;
import be.thomasmore.graduaten.hellospring.entities.Product;
import be.thomasmore.graduaten.hellospring.mapper.ModelMap;
import be.thomasmore.graduaten.hellospring.repositories.CategoryRepository;
import be.thomasmore.graduaten.hellospring.repositories.ProductRepository;
import be.thomasmore.graduaten.hellospring.security.UserDetailsService;
import be.thomasmore.graduaten.hellospring.shared.Converter;
import org.aspectj.weaver.ast.Or;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import org.thymeleaf.util.ArrayUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class HomeController {

    @Autowired
    private ModelMap modelMap;

    @Autowired
    private Converter converter;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/Home")
    public String GetCategoriesAndProductsForHomePage(Model model) {
        List<Category> categories=categoryRepository.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        TypeToken<List<CategoryDto>> typeToken = new TypeToken<>() {
        };
        categoryDtos = modelMap.modelMapper().map(categories,typeToken.getType());
        categoryDtos = ConvertPhotoBase64(categoryDtos);
        model.addAttribute("categories",categoryDtos);
        return "Home";
    }

    @RequestMapping("/")
    public String IndexPage() {return "Index"; }

    @RequestMapping("/Contact")
    public String ContactPage() {return "Contact"; }

    @RequestMapping("/ThankYou")
    public String ThankYouPage() {return "ThankYou"; }

    @RequestMapping("/Login")
    public String LoginPage() {return "Login"; }





    private List<CategoryDto> ConvertPhotoBase64(List<CategoryDto> categories)
    {
        String base64IntroString = "data:image/png;base64, ";
        for(CategoryDto categoryDto : categories){
            for (ProductDto productDto : categoryDto.getProduct()) {
                var photo = productDto.getPhoto();
                if (photo != null  && photo.length > 0) {
                    var fullImageString = base64IntroString +  converter.ConvertByteArrayToBase64(photo);
                    productDto.setImage(fullImageString);
                }
            }
        }

        return categories;
    }



}


