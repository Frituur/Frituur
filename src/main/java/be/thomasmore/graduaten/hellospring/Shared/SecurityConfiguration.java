package be.thomasmore.graduaten.hellospring.Shared;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected  void configure(AuthenticationManagerBuilder auth) throws  Exception {
        // Create the admin for the application

    }

    @Override
    protected  void configure(HttpSecurity httpSecurity) throws Exception{
        //Specify which urls can be accessed for the owner and which are free for all
        httpSecurity.authorizeRequests()
                .antMatchers("/").permitAll()
                .and().formLogin();
    }
}
