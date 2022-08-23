package be.thomasmore.graduaten.hellospring.controllers;


import be.thomasmore.graduaten.hellospring.dto.AdminDto;
import be.thomasmore.graduaten.hellospring.dto.CategoryDto;
import be.thomasmore.graduaten.hellospring.entities.Category;
import be.thomasmore.graduaten.hellospring.entities.Customer;
import be.thomasmore.graduaten.hellospring.entities.Orders;
import be.thomasmore.graduaten.hellospring.entities.Product;
import be.thomasmore.graduaten.hellospring.mapper.ModelMap;
import be.thomasmore.graduaten.hellospring.repositories.CategoryRepository;
import be.thomasmore.graduaten.hellospring.repositories.OrderRepository;
import be.thomasmore.graduaten.hellospring.repositories.ProductRepository;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@Controller
public class AdminController {


    @Autowired
    private ModelMap modelMap;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;


    @RequestMapping("/BestelAdmin")
    public String GetCategoriesAndProductsForAdminPage(Model model) {
        List<Category> categories=categoryRepository.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        TypeToken<List<CategoryDto>> typeToken = new TypeToken<>() {
        };
        categoryDtos = modelMap.modelMapper().map(categories,typeToken.getType());

        model.addAttribute("categories",categoryDtos);
        return "BestelAdmin";
    }


}
