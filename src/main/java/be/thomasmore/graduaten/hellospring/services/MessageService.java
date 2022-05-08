package be.thomasmore.graduaten.hellospring.services;

import be.thomasmore.graduaten.hellospring.entities.Customer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class MessageService {
    // Send messages to users with Twillio API
    // Send a message to the customer when the order is done
    public void SendMessage(Customer customer) {
        // Based on the timeslot when the time is reached application should send a message
        // Daemon running
        //Change the status of the order
        // Send a message using the phone number to the customer
    }

}
