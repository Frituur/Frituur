package be.thomasmore.graduaten.hellospring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Configuration
@Component
public  class PasswordConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();

    }

    public boolean Matches(String userpassword, String dbPassword){
        if(passwordEncoder().matches(userpassword, dbPassword))
            return true;
        return false;
    }
}
