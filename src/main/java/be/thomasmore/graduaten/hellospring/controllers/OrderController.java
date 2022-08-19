package be.thomasmore.graduaten.hellospring.controllers;

import be.thomasmore.graduaten.hellospring.dto.*;
import be.thomasmore.graduaten.hellospring.entities.Customer;
import be.thomasmore.graduaten.hellospring.entities.Orders;
import be.thomasmore.graduaten.hellospring.entities.Product;
import be.thomasmore.graduaten.hellospring.mapper.ModelMap;


import be.thomasmore.graduaten.hellospring.repositories.CustomerRepository;
import be.thomasmore.graduaten.hellospring.repositories.OrderRepository;
import be.thomasmore.graduaten.hellospring.repositories.ProductRepository;
import be.thomasmore.graduaten.hellospring.requests.RequestIds;
import be.thomasmore.graduaten.hellospring.services.OrderService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.modelmapper.ModelMapper;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.Integer.parseInt;

@Controller
public class OrderController {

    @Autowired
    private ModelMap modelMap;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/showorder")
    public ModelAndView ShowOrder(@RequestParam("Order") Orders order) {
        ModelAndView mv = new ModelAndView("BestelKlant");
        OrderDto orderDto = modelMap.modelMapper().map(order, OrderDto.class);
        mv.addObject(order);
        return mv;
    }


    public String FinalOrder() {
        // Eenmaal als tijdslot gekozen is, lijst van producten in orders, naam van klant en telefoon nummer
        // Dan kan hij de final bestelling uitvoeren
        return "/complete";
    }

    @RequestMapping(value = "/makeorder", method = RequestMethod.POST)
    public String MakeOrder(@RequestBody String Json, RedirectAttributes ra) throws IOException {
        Customer customer=new Customer();
        String[] lijst = Json.split("r");
        String[] naamsplit = Json.split("CustomerNaam" + "=");
        String naam = naamsplit[1].substring(0, naamsplit[1].indexOf("&"));
        naam = naam.replace("+", " ");
        String[] adressplit = Json.split("CustomerAdres" + "=");
        String adres = adressplit[1].substring(1,adressplit[1].indexOf("&"));
        adres = adres.replace("+", " ");
        System.out.println(adres);
        if (naam != "" && adres != "") {
            if (Json.contains("=on")) {
                customer.setNaam(naam);
                customer.setAddress(adres);
                Customer customersaved=customerRepository.save(customer);
                for (int i = 0; i < lijst.length; i++) {
                    if (lijst[i].contains("=on")) {
                        String[] getidstring=lijst[i].split("boolean");
                        int getidnum=parseInt(getidstring[1].substring(0,getidstring[1].indexOf("=")));
                        Optional<Product> optionalEntity = productRepository.findById((long) getidnum);
                        Product product = optionalEntity.get();
                        Orders order = new Orders();
                        String splitter=getidnum+"=";
                        String[] lijst2 = lijst[i].split(splitter);
                        int nummer = parseInt(lijst2[1].substring(0, 1));
                        order.setNumberOfProducts(nummer);
                        order.setProduct(product);
                        order.setCustomer(customersaved);
                        orderRepository.save(order);
                        System.out.println(Json);
                    }
                }
                return "redirect:/Tijdslots";
            }
            else
            {
                return "redirect:/Home";
            }
        }
        else
        {
            return "redirect:/Home";
        }



    }
    public static final class ProductRequest {
        List<Product> products;
        public List<Product> getProducts() {
            return products;
        }


    }


        //Orders ophalen van de customers in database
        @GetMapping("/getorders")
        public String GetOrdersFromCustomers () {
            // get the orders from the customers
            return "getorders";
        }


    private Orders ChosenProductsForOrder(List<CategoryDto> categoryDtos, Orders order)
    {
        for (CategoryDto categoryDto : categoryDtos) {
            for (ProductDto productDto : categoryDto.getProduct()) {
                if(productDto.isChosenProduct() == true){
                    Product product = modelMap.modelMapper().map(productDto, Product.class);

                }


                }
            }

            return order;
        }

        public static final class IDRequest {
            List<Integer> ids;

            public void setIds(List<Integer> ids) {
                this.ids = ids;
            }

            public List<Integer> getIds() {
                return ids;
            }
        }






    @RequestMapping("/BestelKlant")
    public String TijdsslotsPage() {return "BestelKlant";}

    @RequestMapping("/BestelAdmin")
    public String BestelPage(Model model) {
        List<Orders> orders=orderRepository.findAll();
        List<OrderDto> orderDtos = new ArrayList<>();
        TypeToken<List<OrderDto>> typeToken = new TypeToken<>() {
        };
        orderDtos = modelMap.modelMapper().map(orders,typeToken.getType());
        System.out.println(orderDtos.isEmpty());
        model.addAttribute("orders",orderDtos);
        return "BestelAdmin";
    }
}


