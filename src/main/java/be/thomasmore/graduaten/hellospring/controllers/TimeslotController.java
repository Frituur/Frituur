package be.thomasmore.graduaten.hellospring.controllers;

import be.thomasmore.graduaten.hellospring.entities.Customer;
import be.thomasmore.graduaten.hellospring.entities.Orders;
import be.thomasmore.graduaten.hellospring.entities.Timeslot;
import be.thomasmore.graduaten.hellospring.repositories.CategoryRepository;
import be.thomasmore.graduaten.hellospring.repositories.CustomerRepository;
import be.thomasmore.graduaten.hellospring.repositories.OrderRepository;
import be.thomasmore.graduaten.hellospring.repositories.TimeslotRepository;
import be.thomasmore.graduaten.hellospring.shared.FileCreater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TimeslotController {

    @Autowired
    private FileCreater fileCreater;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TimeslotRepository timeslotRepository;
    @RequestMapping("/Tijdslots")
    public String TijdslotPagina(Model model, RedirectAttributes ra){
        // Ik krijg de gekozen tijdslot terug) {

        List<Timeslot> tijdslots= GetAllAvailableTimeslots();
        model.addAttribute("tijdslots",tijdslots);
        return "Tijdslots";
    }

    @RequestMapping(value = "/posttijdslot", method = RequestMethod.POST)
    public String SetTimeSlotCustomer(@RequestBody String json, RedirectAttributes ra) throws IOException {
        // Ik krijg de gekozen tijdslot terug
        Long tijdslotid = GetIdFromJson(json);
        System.out.println(tijdslotid);
        var id = fileCreater.ReadFromTempFile();
        long customerid = Long.parseLong(id);
        Customer customer = customerRepository.getById(customerid);
        Timeslot tijdslot =  timeslotRepository.getById(tijdslotid);
        tijdslot.setIsAvailable(false);
        customer.setTimeslot(tijdslot);
        customerRepository.save(customer);
        return "redirect:/finalorder";
    }

    protected List<Timeslot> GetAllAvailableTimeslots() {
        List<Timeslot> timeslots = timeslotRepository.findAll();
        List<Timeslot> allAvailableTimeslot = new ArrayList<>();

        for (Timeslot timeslot : timeslots) {
            if(timeslot.getIsAvailable() == true){
                allAvailableTimeslot.add(timeslot);
            }
        }

        return allAvailableTimeslot;
    }

    protected boolean CheckIfTimeSlotIsAvailable(Timeslot givenTimeslot) {
        List<Timeslot> timeslots = timeslotRepository.findAll();
        //Check if the timeslot exists and is available
        for(Timeslot timeslot : timeslots) {
            if(timeslot.getIsAvailable() == true
                    && timeslot.getTimeArrival() == givenTimeslot.getTimeArrival()){
                return true;
            }
        }

        return false;
    }

    private Long GetIdFromJson(String json ){
        String[] jsonSplit = json.split("=");
        var id = Long.parseLong(jsonSplit[0]);
        return id;
    }
}