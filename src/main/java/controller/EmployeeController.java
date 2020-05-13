package controller;

import exceptions.ItemNotFoundException;
import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.EmployeeCRUDService;

import java.util.List;

@RestController
@RequestMapping(value = "/EmployeeController")
public class EmployeeController {

    @Autowired
    private EmployeeCRUDService employeeCRUDService;

    @PostMapping("/InsertEmployee")
    public void insertEmployee(@RequestBody Employee employee){
        employeeCRUDService.save(employee);
    }

    @GetMapping("/GetByIdEmployee")
    public Employee employeeGetById(@RequestParam int id) throws ItemNotFoundException {
        return employeeCRUDService.findById(id).orElseThrow(() -> new ItemNotFoundException());
    }

    @GetMapping("/FindAllEmloyee")
    public List<Employee> employeeList(){
        return employeeCRUDService.findAll();
    }

    @PostMapping("/UpdateEmloyee")
    public void updateEmployee(@RequestBody Employee employee){
        employeeCRUDService.save(employee);
    }

    @DeleteMapping("/DeleteEmployee")
    public void deleteEmployee(@RequestParam int id){
        employeeCRUDService.deleteById(id);
    }
}
