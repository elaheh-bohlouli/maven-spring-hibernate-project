package controller;

import Commen.ItemNotFoundException;
import model.AskDayOff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.AskDayOffRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/AskDayOffController")
public class AskDayOffController {

    private final AskDayOffRepository askDayOffRepository;
    @Autowired
    public AskDayOffController(AskDayOffRepository askDayOffRepository) {
        this.askDayOffRepository = askDayOffRepository;
    }

    @PostMapping("/InsertAskDayOff")
    public void insertAskDayOff(@RequestBody AskDayOff askDayOff) {
        askDayOffRepository.save(askDayOff);
    }

    @GetMapping("/GetByIdAskDayOff")
    public AskDayOff askDayOff(@RequestParam int id) throws ItemNotFoundException {
        return askDayOffRepository.findById(id).orElseThrow(() -> new ItemNotFoundException());
    }

    @GetMapping("/GetAllAskDayOff")
    public List<AskDayOff> askDayOffList(){
        return askDayOffRepository.findAll();
    }

    @PostMapping("/UpdateAslDayOff")
    public void updateAskDayOff(@RequestBody AskDayOff askDayOff){
        askDayOffRepository.save(askDayOff);
    }

    @DeleteMapping("/DeleteAskDayOff")
    public void delete(@RequestParam int id) {
        askDayOffRepository.deleteById(id);
    }
}
