package controller;

import Commen.ItemNotFoundException;
import model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.EmailRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/EmailController")
public class EmailController {

    private final EmailRepository emailRepository;
    @Autowired
    public EmailController(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @PostMapping("/SentEmail")
    public void sendEmail(@RequestBody Email email){
        emailRepository.save(email);
    }

    @GetMapping("/GetByIdEmail")
    public Email email(@RequestParam int id) throws ItemNotFoundException {
        return emailRepository.findById(id).orElseThrow(() -> new ItemNotFoundException());
    }

    @GetMapping("/GetAllEmail")
    public List<Email> emailList(){
        return emailRepository.findAll();
    }

    @DeleteMapping("/DeleteEmail")
    public void deleteEmail(@RequestParam int id) {
        emailRepository.deleteById(id);
    }
}
