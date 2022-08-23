package be.thomasmore.graduaten.hellospring.controllers;


import be.thomasmore.graduaten.hellospring.dto.AdminDto;
import be.thomasmore.graduaten.hellospring.dto.CategoryDto;
import be.thomasmore.graduaten.hellospring.dto.OrderDto;
import be.thomasmore.graduaten.hellospring.dto.ProductDto;
import be.thomasmore.graduaten.hellospring.entities.Category;
import be.thomasmore.graduaten.hellospring.entities.Customer;
import be.thomasmore.graduaten.hellospring.entities.Orders;
import be.thomasmore.graduaten.hellospring.entities.Product;
import be.thomasmore.graduaten.hellospring.mapper.ModelMap;
import be.thomasmore.graduaten.hellospring.repositories.CategoryRepository;
import be.thomasmore.graduaten.hellospring.repositories.OrderRepository;
import be.thomasmore.graduaten.hellospring.repositories.ProductRepository;
import be.thomasmore.graduaten.hellospring.security.UserDetailsService;
import be.thomasmore.graduaten.hellospring.services.ProductService;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;



@Controller
public class AdminController {


    @Autowired
    private ModelMap modelMap;

    @Autowired
    private ProductService service;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/BestelAdmin")
    public String GetCategoriesAndProductsForAdminPage(Model model) {
        List<Category> categories=categoryRepository.findAll();
        List<CategoryDto> categoryDtos;

        List<Product> products=productRepository.findAll();
        List<ProductDto> productDtos;

/*        List<Orders> orders=orderRepository.findAll();
        List<OrderDto> orderDtos;

        TypeToken<List<OrderDto>> typeTokenOrders = new TypeToken<>(){};
        orderDtos = modelMap.modelMapper().map(orders, typeTokenOrders.getType());*/

        TypeToken<List<CategoryDto>> typeTokenCategory = new TypeToken<>() {};
        categoryDtos = modelMap.modelMapper().map(categories,typeTokenCategory.getType());

        TypeToken<List<ProductDto>> typeTokenProduct = new TypeToken<>(){};
        productDtos = modelMap.modelMapper().map(products,typeTokenProduct.getType());


        model.addAttribute("categories",categoryDtos);
        model.addAttribute("products", productDtos);
//        model.addAttribute("orders", orderDtos);
        return "BestelAdmin";
    }


}
