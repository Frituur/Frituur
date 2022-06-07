package be.thomasmore.graduaten.hellospring.controllers;

import be.thomasmore.graduaten.hellospring.entities.User;
import be.thomasmore.graduaten.hellospring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OwnerController {

    @Qualifier("UserRepository")
    @Autowired
    private UserRepository repository;

    public OwnerController(@Qualifier("UserRepository") UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/owner")
    List<User> all() {
        return repository.findAll();
    }
}
