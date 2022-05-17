package be.thomasmore.graduaten.hellospring.controllers;

import be.thomasmore.graduaten.hellospring.services.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TimeslotController {


    @Autowired
    private final TimeslotService timeslotService;


    public TimeslotController(TimeslotService timeslotService) {
        this.timeslotService = timeslotService;
    }
}
