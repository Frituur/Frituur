package be.thomasmore.graduaten.hellospring.controllers;

import be.thomasmore.graduaten.hellospring.entities.Orders;
import be.thomasmore.graduaten.hellospring.entities.Timeslot;
import be.thomasmore.graduaten.hellospring.repositories.CategoryRepository;
import be.thomasmore.graduaten.hellospring.repositories.OrderRepository;
import be.thomasmore.graduaten.hellospring.repositories.TimeslotRepository;
import be.thomasmore.graduaten.hellospring.services.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TimeslotController {




    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private TimeslotRepository timeslotRepository;
    @RequestMapping("/Tijdslots")
    public String TijdslotPagina(Model model) {
        List<Timeslot> tijdslots= timeslotRepository.findAll();


        model.addAttribute("tijdslots",tijdslots);
        return "Tijdslots";
    }
}
