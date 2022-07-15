package be.thomasmore.graduaten.hellospring.controllers;

import be.thomasmore.graduaten.hellospring.dto.CategoryDto;
import be.thomasmore.graduaten.hellospring.dto.OrderDto;
import be.thomasmore.graduaten.hellospring.dto.ProductDto;
import be.thomasmore.graduaten.hellospring.entities.Orders;
import be.thomasmore.graduaten.hellospring.entities.Product;
import be.thomasmore.graduaten.hellospring.mapper.ModelMap;
import be.thomasmore.graduaten.hellospring.repositories.OrderRespository;
import be.thomasmore.graduaten.hellospring.services.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private ModelMap modelMap;

    @Autowired
    private OrderService orderService;

    @GetMapping("/showorder")
    public ModelAndView ShowOrder(@RequestParam("Order") Orders order){
        ModelAndView mv = new ModelAndView("BestelKlant");
        OrderDto orderDto = modelMap.modelMapper().map(order, OrderDto.class);
        mv.addObject(order);
        return mv;

    }


    public String FinalOrder(){
        // Eenmaal als tijdslot gekozen is, lijst van producten in orders, naam van klant en telefoon nummer
        // Dan kan hij de final bestelling uitvoeren

        return "/complete";
    }

    @RequestMapping(value = "/makeorder", params = "btnOrder",method = RequestMethod.POST)
    public ModelAndView MakeOrder(@RequestBody List<CategoryDto> categories) throws IOException {
        // get all categories back

        Orders order = new Orders();
        order = ChosenProductsForOrder(categories, order);
        System.out.println(categories.size());
        System.out.println("Making order");
        System.out.println(order.getId());
        //double totalPrice = orderService.CalculateTotalPrice(order);
        //System.out.println(totalPrice);
        System.out.println(order.getId());
        //order.setTotalPrice(totalPrice);
        ModelAndView mv = new ModelAndView("redirect:/showorder");
        mv.addObject(order);

        return mv;
    }

    //Orders ophalen van de customers in database
    @GetMapping("/getorders")
    public String GetOrdersFromCustomers() {
        // get the orders from the customers
        return "getorders";
    }

    private Orders ChosenProductsForOrder(List<CategoryDto> categoryDtos, Orders order)
    {
        for (CategoryDto categoryDto : categoryDtos) {
            for (ProductDto productDto : categoryDto.getProduct()) {
                if(productDto.isChosenProduct() == true){
                    Product product = modelMap.modelMapper().map(productDto, Product.class);
                    order.getProduct().add(product);
                }

            }
        }

        return order;
    }
}
