package controller;

import model.Email;
import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/EmailController")
public class EmailController {

    @Autowired
    private Email email;

    @PostMapping("/InsertAskDayOff")
    public void insertAskDayOff(@RequestBody Employee employee){}
}
