package be.thomasmore.graduaten.hellospring.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;

public interface ErrorrHandlerController2 extends ErrorController {
    @GetMapping("/error")
    String customError();

    String getErrorPath();
}
