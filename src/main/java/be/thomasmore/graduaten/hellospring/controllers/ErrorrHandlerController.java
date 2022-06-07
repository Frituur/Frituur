package be.thomasmore.graduaten.hellospring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorrHandlerController implements ErrorrHandlerControllerInterface {

    @Override
    @GetMapping("/error")
    public String customError() {
        return "The link you followed may be broken, or the page may have been removed.";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}