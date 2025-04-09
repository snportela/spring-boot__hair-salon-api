package com.snportela.hair_salon.controller;

import com.snportela.hair_salon.dto.EmployeeDto;
import com.snportela.hair_salon.mapper.EmployeeMapper;
import com.snportela.hair_salon.model.Employee;
import com.snportela.hair_salon.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    private final EmployeeMapper employeeMapper;

    public EmployeeController(EmployeeService employeeService, EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> listEmployees() {
        List<EmployeeDto> employeeDtoList = employeeService.findAll().stream().map(employeeMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(employeeDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") UUID employeeId) {
        Employee foundEmployee = employeeService.findOne(employeeId);
        return ResponseEntity.status(HttpStatus.OK).body(employeeMapper.toDto(foundEmployee));
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        Employee savedEmployee = employeeService.save(employeeMapper.fromDto(employeeDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeMapper.toDto(savedEmployee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(
            @PathVariable("id") UUID employeeId, @RequestBody EmployeeDto employeeDto
    ) {
        Employee updatedEmployee = employeeService.update(employeeId, employeeMapper.fromDto(employeeDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeMapper.toDto(updatedEmployee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") UUID employeeId) {
        employeeService.delete(employeeId);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted employee with ID: " + employeeId);
    }

}
