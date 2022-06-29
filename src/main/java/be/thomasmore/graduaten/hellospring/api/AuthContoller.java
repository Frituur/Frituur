package be.thomasmore.graduaten.hellospring.api;

import be.thomasmore.graduaten.hellospring.dto.UserDto;
import be.thomasmore.graduaten.hellospring.repositories.UserRepository;
import be.thomasmore.graduaten.hellospring.security.PasswordConfig;
import be.thomasmore.graduaten.hellospring.security.SecurityConfiguration;
import be.thomasmore.graduaten.hellospring.security.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("api/auth")
public class AuthContoller {


    @Autowired
    private DaoAuthenticationProvider DaoAuthenticationProvider;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailsService userDetailsService;


    public AuthContoller(UserDetailsService userDetailsService){
        userDetailsService = userDetailsService;
    }

    @RequestMapping(value = "/hallo", method = RequestMethod.GET)
    public String GetHallo(){
        return "Hallo";

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String GetUsername(@PathVariable @NotNull Long id){
        return userDetailsService.GetUsername(id);

    }


    @RequestMapping(value="/welcome/", method=RequestMethod.POST)
    public String welcomepage() {
        return "Welkom bij het half kieke\n";
    }

    @PostMapping("/signin")
    @ResponseBody
    public ResponseEntity<String> authenticateUser(UserDto userDto) throws AuthenticationException {
        System.out.println("Start authentication");

        try {
            var user = userDetailsService.loadUserByUsername(userDto.getUsername());
            System.out.println(user.getUsername());
            var isLoggedIn = userDetailsService.checkLogin(userDto.getUsername(), userDto.getPassword());
            if(isLoggedIn){
                return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
            }
            return new ResponseEntity<>("You have entered the wrong password or username. Check database.", HttpStatus.EXPECTATION_FAILED);


        }catch (Exception ex){
            System.out.println(ex.getCause());
            System.out.println(ex.getMessage());

            if (!this.DaoAuthenticationProvider.isHideUserNotFoundExceptions()) {
                System.out.println("Bad Credentials");
                throw ex;
            }

        }

        return null;
    }
}
