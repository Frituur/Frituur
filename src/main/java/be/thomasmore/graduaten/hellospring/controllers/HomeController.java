package be.thomasmore.graduaten.hellospring.controllers;

import com.fasterxml.jackson.databind.ser.std.SqlTimeSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String navigateToIndex() {
        return "Home";
    }


    @RequestMapping("/Detail")
    public String navigateToDetail() {
        return "Detail";
    }

    @RequestMapping("/Login")
    public String navigateToLogin() {
        return "Login";
    }


    @RequestMapping("/Tijdsslots")
    public String navigateToTijdsslots() {
        return "Tijdsslots";
    }

    @RequestMapping("/BestelKlant")
    public String navigateToBestel() {
        return "BesteloverzichtKlant";
    }

    @RequestMapping("/BestelAdmin")
    public String navigateToBestelAdmin() {
        return "BesteloverzichtAdmin";
    }
}


