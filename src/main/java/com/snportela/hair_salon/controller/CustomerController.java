package com.snportela.hair_salon.controller;

import com.snportela.hair_salon.dto.CustomerDto;
import com.snportela.hair_salon.mapper.CustomerMapper;
import com.snportela.hair_salon.model.Customer;
import com.snportela.hair_salon.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    private final CustomerMapper customerMapper;

    public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> listCustomers() {
        List<CustomerDto> customerDtoList = customerService.findAll().stream().map(customerMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(customerDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("id") UUID customerId) {
        Customer foundCustomer = customerService.findOne(customerId);
        return ResponseEntity.status(HttpStatus.OK).body(customerMapper.toDto(foundCustomer));
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        Customer savedCustomer = customerService.save(customerMapper.fromDto(customerDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(customerMapper.toDto(savedCustomer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(
            @PathVariable("id") UUID customerId, @RequestBody CustomerDto customerDto
    ) {
        Customer updatedCustomer = customerService.update(customerId, customerMapper.fromDto(customerDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(customerMapper.toDto(updatedCustomer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") UUID customerId) {
        customerService.delete(customerId);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted customer with ID: " + customerId);
    }
}
