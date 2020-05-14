package com.ela.service;

import com.ela.model.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    void create(Employee employee);
    Optional<Employee> findById(int id);
    List<Employee> findAll();
    void deleteById(int id);
    void update(Employee employee);
}
