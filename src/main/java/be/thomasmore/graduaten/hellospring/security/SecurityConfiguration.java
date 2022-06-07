package be.thomasmore.graduaten.hellospring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService UserDetailsService;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    public  SecurityConfiguration(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected  void configure(AuthenticationManagerBuilder auth) throws  Exception {
        // Create the admin for the application
        auth.authenticationProvider(daoAuthenticationProvider());


    }

    @Override
    protected  void configure(HttpSecurity httpSecurity) throws Exception{
        //Specify which urls can be accessed for the owner and which are free for all
        httpSecurity
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/")
                .permitAll()
                .and().formLogin().loginPage("/login").permitAll()
                .and().logout().permitAll()
                .and()
                .httpBasic();


    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        // Add default user admin
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        daoAuthenticationProvider.setUserDetailsService(UserDetailsService);


        return daoAuthenticationProvider;
    }


}
