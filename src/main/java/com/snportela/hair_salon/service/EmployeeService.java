package com.snportela.hair_salon.service;

import com.snportela.hair_salon.model.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findOne(UUID employeeId);

    Employee save(Employee employee);

    Employee update(UUID employeeId, Employee employee);

    void delete(UUID employeeId);
}
