package controller;

import exceptions.ItemNotFoundException;
import model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.EmailCRUDService;

import java.util.List;

@RestController
@RequestMapping(value = "/EmailController")
public class EmailController {

    @Autowired
    private EmailCRUDService emailCRUDService;

    @PostMapping("/SentEmail")
    public void sendEmail(@RequestBody Email email){

        emailCRUDService.save(email);
    }

    @GetMapping("/GetByIdEmail")
    public Email email(@RequestParam int id) throws ItemNotFoundException {
        return emailCRUDService.findById(id).orElseThrow(() -> new ItemNotFoundException());
    }

    @GetMapping("/GetAllEmail")
    public List<Email> emailList(){
        return emailCRUDService.findAll();
    }

    @DeleteMapping("/DeleteEmail")
    public void deleteEmail(@RequestParam int id) {
        emailCRUDService.deleteById(id);
    }
}
