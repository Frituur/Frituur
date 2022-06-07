package be.thomasmore.graduaten.hellospring.security;

import be.thomasmore.graduaten.hellospring.entities.User;
import be.thomasmore.graduaten.hellospring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private  PasswordConfig passwordConfig;


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String UsernameOrEmail) throws UsernameNotFoundException {
        // Maak een nieuw user object
        System.out.println("Trying to get user");
        return userRepository.findUserByEmail(UsernameOrEmail).orElseThrow(() ->
                new UsernameNotFoundException("User not found with username or email:"  + UsernameOrEmail));

    }

    public boolean checkLogin(String userName, String password){
        // TODO Auto-generated method stub
        Optional<User> user = userRepository.findUserByEmail(userName);
        if (user.isPresent() && passwordConfig.Matches(password, user.get().getPassword())) {
            return true;
        }
        return false;
    }



    public String GetUsername(long id) {
        return userRepository.getById(id).getUsername();
    }


}
