package controller;

import exceptions.ItemNotFoundException;
import model.AskDayOff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.AskDayOffService;

import java.util.List;

@RestController
@RequestMapping(value = "/AskDayOffController")
public class AskDayOffController {
    @Autowired
    private AskDayOffService askDayOffService;

    @PostMapping("/InsertAskDayOff")
    public void insertAskDayOff(@RequestBody AskDayOff askDayOff) {
        askDayOffService.creat(askDayOff);
    }

    @GetMapping("/GetByIdAskDayOff")
    public AskDayOff askDayOff(@RequestParam int id) throws ItemNotFoundException {
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
        askDayOffService.delete(id);
    }
}
