package controller;

import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.EmployeeRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/EmployeeController")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping("/InsertEmployee")
    public void insertEmployee(@RequestBody Employee employee){
        employeeRepository.save(employee);
    }

    @GetMapping("/GetByIdEmployee")
    public Employee employeeGetById(@RequestParam int id) throws ItemNotFoundException {
        return employeeRepository.findById(id).orElseThrow(() -> new ItemNotFoundException());
    }

    @GetMapping("/FindAllEmloyee")
    public List<Employee> employeeList(){
        return employeeRepository.findAll();
    }

    @PostMapping("/UpdateEmloyee")
    public void updateEmployee(@RequestBody Employee employee){
        employeeRepository.save(employee);
    }

    @DeleteMapping("/DeleteEmployee")
    public void deleteEmployee(@RequestParam int id){
        employeeRepository.deleteById(id);
    }
}
