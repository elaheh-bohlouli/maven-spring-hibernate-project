package controller;

import model.AskDayOff;
import model.Employee;
import org.springframework.web.bind.annotation.*;
import repository.AskDayOffRepository;
import repository.EmployeeRepository;
import java.util.List;

@RestController
@RequestMapping(value = "/AskDayOff")
public class AskDayOffController {

    private AskDayOffRepository askDayOffRepository;
    private EmployeeRepository employeeRepository;

    @PostMapping("/InsertAskDayOff")
    public void insertAskDayOff(@RequestBody AskDayOff askDayOff) {
        askDayOffRepository.save(askDayOff);
    }

    @GetMapping("/GetAllAskDayOff")
    public List<AskDayOff> askDayOffList(@RequestParam Employee employee) {
        return askDayOffRepository.findAll();
    }

    @DeleteMapping("/DeleteAskDayOff")
    public void delete(@RequestParam int id) {
        askDayOffRepository.deleteById(id);
    }
}
