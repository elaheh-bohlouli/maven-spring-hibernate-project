package controller;

import exceptions.ItemNotFoundException;
import model.AskDayOff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.AskDayOffService;

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
}
