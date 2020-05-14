package com.ela.controller;

import com.ela.exceptions.ItemNotFoundException;
import com.ela.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ela.service.EmailService;

import java.util.List;

@RestController
@RequestMapping(value = "/EmailController")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/SentEmail")
    public void sendEmail(@RequestBody Email email){

        emailService.create(email);
    }

    @GetMapping("/GetByIdEmail")
    public Email email(@RequestParam int id) throws ItemNotFoundException {
        return emailService.findById(id).orElseThrow(() -> new ItemNotFoundException());
    }

    @GetMapping("/GetAllEmail")
    public List<Email> emailList(){
        return emailService.findAll();
    }

    @DeleteMapping("/DeleteEmail")
    public void deleteEmail(@RequestParam int id) {
        emailService.deleteById(id);
    }
}
