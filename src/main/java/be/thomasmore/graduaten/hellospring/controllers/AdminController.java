package be.thomasmore.graduaten.hellospring.controllers;


import be.thomasmore.graduaten.hellospring.dto.*;
import be.thomasmore.graduaten.hellospring.entities.*;
import be.thomasmore.graduaten.hellospring.mapper.ModelMap;
import be.thomasmore.graduaten.hellospring.repositories.*;

import org.modelmapper.TypeToken;
import org.simpleframework.xml.Path;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;



@Controller
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    private ModelMap modelMap;

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private TimeslotRepository timeslotRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TimeslotRepository timeslotRepository;


    @RequestMapping("/EditTimeslots")
    public String EditTimeslots(Model model) {
        // Haal alle timeslots op
        // vull de tijdslots in een time picker voor hoeveel er zijn in de tijdslotsdb
        var tijdslotsdb =  timeslotRepository.findAll();
        model.addAttribute("timeslots", tijdslotsdb);
        return "edittimeslots";
    }

    @RequestMapping("/BestelAdmin")
    public String GetCategoriesAndProductsForAdminPage(Model model) {
        List<Category> categories=categoryRepository.findAll();
        List<CategoryDto> categoryDtos;

        List<Product> products=productRepository.findAll();
        List<ProductDto> productDtos;

        List<Customer> customers=customerRepository.findAll();
        List<CustomerDto> customerDtos;

        List<Timeslot> timeslots=timeslotRepository.findAll();
        List<TimeslotDto> timeslotDtos;

        TypeToken<List<TimeslotDto>> typeTokenTimeslot = new TypeToken<>(){};
        timeslotDtos = modelMap.modelMapper().map(timeslots,typeTokenTimeslot.getType());

        TypeToken<List<CustomerDto>> typeTokenCustomer = new TypeToken<>(){};
        customerDtos = modelMap.modelMapper().map(customers,typeTokenCustomer.getType());

        TypeToken<List<CategoryDto>> typeTokenCategory = new TypeToken<>() {};
        categoryDtos = modelMap.modelMapper().map(categories,typeTokenCategory.getType());

        TypeToken<List<ProductDto>> typeTokenProduct = new TypeToken<>(){};
        productDtos = modelMap.modelMapper().map(products,typeTokenProduct.getType());


        model.addAttribute("categories",categoryDtos);
        model.addAttribute("customers",customerDtos);
        model.addAttribute("products", productDtos);
        model.addAttribute("timeslots", timeslotDtos);

//        model.addAttribute("orders", orderDtos);
        return "BestelAdmin";
    }
    @PostMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable Long id){
        customerRepository.deleteById(id);
        return "redirect:/BestelAdmin";
    }

    @PostMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return "redirect:/BestelAdmin";
    }


}
