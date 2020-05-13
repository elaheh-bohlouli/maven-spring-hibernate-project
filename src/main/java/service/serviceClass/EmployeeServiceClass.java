package service.serviceClass;

import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EmployeeRepository;
import service.EmployeeService;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceClass implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private Employee employee;


    @Override
    public void create(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }


    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.save(employee);
    }
}