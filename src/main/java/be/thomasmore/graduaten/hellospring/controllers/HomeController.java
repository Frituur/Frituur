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
   }


