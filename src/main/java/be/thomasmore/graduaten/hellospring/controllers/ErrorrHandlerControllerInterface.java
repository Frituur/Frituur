package be.thomasmore.graduaten.hellospring.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;

public interface ErrorrHandlerControllerInterface extends ErrorController {
    @GetMapping("/error")
    String customError();

    String getErrorPath();
}
