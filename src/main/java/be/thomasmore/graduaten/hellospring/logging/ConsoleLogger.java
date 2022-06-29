package be.thomasmore.graduaten.hellospring.logging;

import org.springframework.stereotype.Component;

@Component
public class ConsoleLogger {

    public void PrintMessage(String message) {
        System.out.println(message);

    }


}
