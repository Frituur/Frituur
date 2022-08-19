package be.thomasmore.graduaten.hellospring.controllers;


import be.thomasmore.graduaten.hellospring.dto.AdminDto;
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
        List<Category> categoriesAdmin=categoryRepository.findAll();
        List<AdminDto> adminDtos;
        TypeToken<List<AdminDto>> typeToken = new TypeToken<>() {
        };
        adminDtos = modelMap.modelMapper().map(categoriesAdmin,typeToken.getType());

        model.addAttribute("categoriesAdmin",adminDtos);
        return "BestelAdmin";
    }

    @RequestMapping("/BestelAdmin")
    public String GetOrdersForAdminPage(Model model) {
        List<Orders> ordersAdmin=orderRepository.findAll();
        List<AdminDto> adminDtos;
        TypeToken<List<AdminDto>> typeToken = new TypeToken<>() {
        };
        adminDtos = modelMap.modelMapper().map(ordersAdmin,typeToken.getType());

        model.addAttribute("ordersAdmin",adminDtos);
        return "BestelAdmin";
    }

    @RequestMapping("/BestelAdmin")
    public String GetProductsForAdmin(Model model) {
        List<Product> ordersProduct=productRepository.findAll();
        List<AdminDto> adminDtos;
        TypeToken<List<AdminDto>> typeToken = new TypeToken<>() {
        };
        adminDtos = modelMap.modelMapper().map(ordersProduct,typeToken.getType());

        model.addAttribute("productAdmin",adminDtos);
        return "BestelAdmin";
    }


}
