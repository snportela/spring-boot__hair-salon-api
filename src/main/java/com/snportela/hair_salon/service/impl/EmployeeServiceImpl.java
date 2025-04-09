package com.snportela.hair_salon.service.impl;

import com.snportela.hair_salon.exception.NotFoundException;
import com.snportela.hair_salon.model.Employee;
import com.snportela.hair_salon.repository.EmployeeRepository;
import com.snportela.hair_salon.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findOne(UUID employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(NotFoundException::new);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(UUID employeeId, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(employeeId).orElseThrow(NotFoundException::new);

        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPhone(employee.getPhone());
        existingEmployee.setRole(employee.getRole());

        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void delete(UUID employeeId) {
        employeeRepository.findById(employeeId).orElseThrow(NotFoundException::new);
        employeeRepository.deleteById(employeeId);
    }
}
