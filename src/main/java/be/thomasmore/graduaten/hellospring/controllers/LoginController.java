package be.thomasmore.graduaten.hellospring.controllers;

import be.thomasmore.graduaten.hellospring.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {

    @Autowired
    private LoginService LoginService;

}
