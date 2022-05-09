package be.thomasmore.graduaten.hellospring.security;

import be.thomasmore.graduaten.hellospring.entities.User;
import be.thomasmore.graduaten.hellospring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private static final String UserMessage = "The Owner with email %s couldn't not be found";

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Maak een nieuw user object
        return  userRepository.findUserByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException(String.format(UserMessage, email)));


    }
}
