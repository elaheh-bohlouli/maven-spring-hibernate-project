package com.ela.controller;

import com.ela.exceptions.DoNotMatchThisAskDayOffWithThisHeadException;
import com.ela.exceptions.EmployeeIsNotHeadException;
import com.ela.exceptions.ItemNotFoundException;
import com.ela.model.AskDayOff;
import com.ela.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ela.service.AskDayOffService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/AskDayOffController")
public class AskDayOffController {
    @Autowired
    private AskDayOffService askDayOffService;

    @PostMapping("/InsertAskDayOff")
    public void insertAskDayOff(@RequestBody AskDayOff askDayOff) {
        askDayOffService.create(askDayOff);
    }

    @GetMapping("/GetByIdAskDayOff")
    public Optional<AskDayOff> askDayOff(@RequestParam int id) throws ItemNotFoundException {
        return askDayOffService.findById(id);
    }

    @GetMapping("/GetAllAskDayOff")
    public List<AskDayOff> askDayOffList(){
        return askDayOffService.findAll();
    }

    @PostMapping("/UpdateAslDayOff")
    public void updateAskDayOff(@RequestBody AskDayOff askDayOff){
        askDayOffService.update(askDayOff);
    }

    @DeleteMapping("/DeleteAskDayOff")
    public void delete(@RequestParam int id) {
        askDayOffService.deleteById(id);
    }

    @GetMapping("/findAllAskDayOffOneHead")
    public List<AskDayOff> findAllAskDayOffOneHead(@RequestBody Employee head) throws EmployeeIsNotHeadException {
        return askDayOffService.findAllAskDayOffOneHead(head);
    }

    @GetMapping("/acceptAskDayOff")
    public void acceptAskDayOff(int askDayOffId, Employee head) throws EmployeeIsNotHeadException, DoNotMatchThisAskDayOffWithThisHeadException {
        askDayOffService.acceptAskDayOff(askDayOffId, head);
    }

    @GetMapping("/rejectAskDayOff")
    public void rejectAskDayOff (int askDayOffId, Employee head) throws EmployeeIsNotHeadException, DoNotMatchThisAskDayOffWithThisHeadException {
        askDayOffService.rejectAskDayOff(askDayOffId, head);
    }
}
