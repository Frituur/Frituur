package be.thomasmore.graduaten.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @GetMapping("/home")
   public String Index() {
        System.out.println("Hello world");
        return "index.html";
   }
}
