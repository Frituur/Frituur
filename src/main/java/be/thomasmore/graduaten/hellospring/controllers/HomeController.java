package be.thomasmore.graduaten.hellospring.controllers;

import be.thomasmore.graduaten.hellospring.security.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class HomeController {

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping("/")
    public String HomePage() {return "Home";}

    @RequestMapping("/Detail")
    public String DetailPage() {return "Detail"; }

    @RequestMapping("/Login")
    public String LoginPage() {return "Login"; }

    @RequestMapping("/BestelKlant")
    public String TijdsslotsPage() {return "BestelKlant";}

    @RequestMapping("/BestelAdmin")
    public String BestelPage() {return "BestelAdmin";}


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @PostMapping("/check-login")
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


