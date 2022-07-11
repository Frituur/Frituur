package be.thomasmore.graduaten.hellospring.controllers;

import be.thomasmore.graduaten.hellospring.dto.UserDto;
import be.thomasmore.graduaten.hellospring.entities.User;
import be.thomasmore.graduaten.hellospring.repositories.UserRepository;
import be.thomasmore.graduaten.hellospring.security.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {

    @Qualifier("UserRepository")
    @Autowired
    private UserRepository repository;

    @Autowired
    private UserDetailsService userDetailsService;

    public LoginController(@Qualifier("UserRepository") UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/owner")
    List<User> all() {
        return repository.findAll();
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("Login");
        UserDto userDto = new UserDto();
        mv.addObject("user", userDto);
        return mv;
    }

    @PostMapping("/trylogin")
    @ResponseBody
    public RedirectView checkLogin(HttpServletRequest request, @RequestParam("username") String userName,
                                   @RequestParam("password") String password, RedirectAttributes redirectAttributes) {
        if (userDetailsService.checkLogin(userName, password)) {
            if (SecurityContextHolder.getContext().getAuthentication() == null ||
                    SecurityContextHolder.getContext()
                            .getAuthentication().getClass().equals(AnonymousAuthenticationToken.class)) {
                UsernamePasswordAuthenticationToken token =
                        new UsernamePasswordAuthenticationToken(userName, password,new ArrayList<>());
                SecurityContextHolder.getContext().setAuthentication(token);
            }
            redirectAttributes.addFlashAttribute("message", "Login Successful");
            return new RedirectView("Home");

        }
        redirectAttributes.addFlashAttribute("message", "Invalid Username or Password");
        return new RedirectView("login");
    }
}
