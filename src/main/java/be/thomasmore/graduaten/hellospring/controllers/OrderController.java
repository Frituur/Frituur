package be.thomasmore.graduaten.hellospring.controllers;

import be.thomasmore.graduaten.hellospring.dto.*;
import be.thomasmore.graduaten.hellospring.entities.Customer;
import be.thomasmore.graduaten.hellospring.entities.Orders;
import be.thomasmore.graduaten.hellospring.entities.Product;
import be.thomasmore.graduaten.hellospring.entities.Timeslot;
import be.thomasmore.graduaten.hellospring.mapper.ModelMap;


import be.thomasmore.graduaten.hellospring.repositories.CustomerRepository;
import be.thomasmore.graduaten.hellospring.repositories.OrderRepository;
import be.thomasmore.graduaten.hellospring.repositories.ProductRepository;
import be.thomasmore.graduaten.hellospring.repositories.TimeslotRepository;
import be.thomasmore.graduaten.hellospring.requests.RequestIds;
import be.thomasmore.graduaten.hellospring.shared.Converter;
import be.thomasmore.graduaten.hellospring.shared.FileCreater;
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
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.lang.Integer.parseInt;

@Controller
public class OrderController {

    @Autowired
    private Converter converter;

    @Autowired
    private FileCreater fileCreater;

    @Autowired
    private ModelMap modelMap;

    @Autowired
    private TimeslotRepository timeslotRepository;

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


    @RequestMapping(value = "/finalorder")
    public String FinalOrder(Model model) throws IOException {

        EndOrderDto endOrderDto = new EndOrderDto();
        List<Timeslot> tijdslots= GetAllAvailableTimeslots();
        var id = fileCreater.ReadFromTempFile();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        long customerid = Long.parseLong(id);
        System.out.println("The customer id is " + customerid);
        Customer customer = customerRepository.getById(customerid);
        List<Orders> allOrders = orderRepository.findAll();
        List<Orders> ordersFromCustomer =  GetAllOrdersFromCustomer(customerid, allOrders);
        List<ProductDto> productDtos = SetProductDtosForOrderCustomer(ordersFromCustomer);
        Double TotalPrice = CalculateTotalPrice(ordersFromCustomer);
        customer.setTotalprice(TotalPrice);
        System.out.println("The total price is " + tijdslots.stream().count());
        customerRepository.save(customer);
        endOrderDto.setTimeslots(tijdslots);
        endOrderDto.setCustomerName(customer.getNaam());
        endOrderDto.setTotalPrice(TotalPrice);
        endOrderDto.setCustomerAddress(customer.getAddress());
        endOrderDto.setToday(now.toLocalDate());
        endOrderDto.setProductDtos(productDtos);
        model.addAttribute("order", endOrderDto);
        return "/orderready";
    }

    @RequestMapping(value = "/makeorder", method = RequestMethod.POST)
    public String MakeOrder(@RequestBody String Json, RedirectAttributes ra) throws IOException {
        Customer customer=new Customer();
        String[] lijst = Json.split("r");
        String[] naamsplit = Json.split("CustomerNaam" + "=");
        String naam = naamsplit[1].substring(0, naamsplit[1].indexOf("&"));
        naam = naam.replace("+", " ");
        int numberOfOrderedItems = 0;
       String[] adressplit = Json.split("CustomerAdres" + "=");
        System.out.println(adressplit);
        String adres = adressplit[1].substring(0, adressplit[1].indexOf("&"));
        adres = adres.replace("+", " ");
        if (naam != "" && adres != "") {
            if (Json.contains("=on")) {
                customer.setNaam(naam);
                customer.setAddress(adres);
                Customer customersaved=customerRepository.save(customer);
                fileCreater.WriteToTempFile(customersaved.getId().toString());
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
                        numberOfOrderedItems += nummer;
                        order.setNumberOfProducts(nummer);
                        order.setProduct(product);
                        order.setCustomer(customersaved);
                        orderRepository.save(order);
                        numberOfOrderedItems++;
                    }
                }
                if(numberOfOrderedItems < 20) {
                    return "redirect:/finalorder";
                }
                return "/";
            }
            else
            {
                return "redirect:/";
            }
        }
        else
        {
            return "redirect:/";
        }



    }
    public static final class ProductRequest {
        List<Product> products;
        public List<Product> getProducts() {
            return products;
        }


    }


    @RequestMapping(value = "/tijdslotpost", method = RequestMethod.POST)
    public String PostTijdSlotKlant(String json) throws IOException {
        System.out.println("hello world" + json);
        if(json == null){
            return "/";
        }
        Long idhal = Long.valueOf(5);
        var tijdslot = timeslotRepository.getById(idhal);
        var id = fileCreater.ReadFromTempFile();
        long customerid = Long.parseLong(id);
        System.out.println(json);
        var customer = customerRepository.getById(customerid);
        customer.setTimeslot(tijdslot);
        fileCreater.ClearTempFile("temp2.txt");
        return "ThankYou";
        //Je een tijdslot terug
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

    public double CalculatePriceProduct(Orders Order){
        // Go through the list of  products
        Double totalPrice = 0.0;
        Product product = Order.getProduct();
        int quantityOfProducts = Order.getNumberOfProducts();
        totalPrice += product.getPrice() * quantityOfProducts;
        return totalPrice;
    }

    public List<Orders> GetAllOrdersFromCustomer(Long customerid, List<Orders> orders){
        List<Orders> ordersFromCustomer = new ArrayList<>();
        for (var order : orders) {
            if(customerid == order.getCustomer().getId()){
                ordersFromCustomer.add(order);
            }
        }

        return ordersFromCustomer;
    }

    public Double CalculateTotalPrice(List<Orders> orders){
        Double TotalPriceCustomer = 0.0;
        for (var order : orders) {
            TotalPriceCustomer += CalculatePriceProduct(order);
        }
        return TotalPriceCustomer;
    }


    protected List<Timeslot> GetAllAvailableTimeslots() {
        List<Timeslot> timeslots = timeslotRepository.findAll();
        List<Timeslot> allAvailableTimeslot = new ArrayList<>();
        LocalTime now = LocalTime.now();
        String target = now.toString();


        for (Timeslot timeslot : timeslots) {
            LocalTime timeslotDb = timeslot.getBegintime().toLocalTime();
            if(timeslot.getIsAvailable() == true && timeslotDb.isAfter(LocalTime.parse(target))){
                allAvailableTimeslot.add(timeslot);
            }
        }

        return allAvailableTimeslot;
    }


    private Long GetIdFromJson(String json ){
        String[] jsonSplit = json.split("=");
        var id = Long.parseLong(jsonSplit[0]);
        return id;
    }


    private List<ProductDto> SetProductDtosForOrderCustomer(List<Orders> Orders){
        List<ProductDto> productDtos = new ArrayList<>();
        for (var order : Orders) {
            ProductDto productDto = new ProductDto();
            productDto.setName(order.getProduct().getName());
            productDto.setPrice(order.getProduct().getPrice());
            productDto.setQuantity(order.getNumberOfProducts());
            productDtos.add(productDto);
        }
        productDtos = ConvertPhotoBase64(productDtos);
        return productDtos;
    }

    private List<ProductDto> ConvertPhotoBase64(List<ProductDto> products)
    {
        String base64IntroString = "data:image/png;base64, ";
            for (ProductDto productDto : products) {
                var photo = productDto.getPhoto();
                if (photo != null  && photo.length > 0) {
                    var fullImageString = base64IntroString +  converter.ConvertByteArrayToBase64(photo);
                    productDto.setImage(fullImageString);
                }
            }

        return products;
    }
}



