package be.thomasmore.graduaten.hellospring.services;

import be.thomasmore.graduaten.hellospring.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository LoginRepository;

    // The owner should be able to login with username and password
    // The owner should be able to restore password when lost


    //

}
