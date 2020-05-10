package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.EmployeeRepository;

@RestController
@RequestMapping(value = "/EmployeeController")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;


}
