package be.thomasmore.graduaten.hellospring.services;

import be.thomasmore.graduaten.hellospring.entities.Timeslot;
import be.thomasmore.graduaten.hellospring.repositories.TimeslotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class TimeslotService {

    @Autowired
    private final TimeslotRepository timeslotRepository;


    public TimeslotService(TimeslotRepository timeslotRepository) {
        this.timeslotRepository = timeslotRepository;
    }

    protected void MakeNewTimeSlot(Timeslot timeslot) {
        timeslotRepository.save(timeslot);
    }

    protected List<Timeslot> GetAllTimeSlots() {
        return timeslotRepository.findAll();
    }

    protected void DeleteTimeSlot(Long id) {
        Timeslot timeslot = timeslotRepository.getById(id);
        timeslotRepository.delete(timeslot);
    }

    protected  void DeleteAllTimeSlots() {
        timeslotRepository.deleteAll();
    }

    protected List<Timeslot> GetAllAvailableTimeslots() {
        List<Timeslot> timeslots = timeslotRepository.findAll();
        List<Timeslot> allAvailableTimeslot = new ArrayList<>();

        for (Timeslot timeslot : timeslots) {
            if(timeslot.getAvailable() == true){
                allAvailableTimeslot.add(timeslot);
            }
        }

        return allAvailableTimeslot;
    }
}
