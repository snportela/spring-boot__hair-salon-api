package com.snportela.hair_salon.service.impl;

import com.snportela.hair_salon.exception.NotFoundException;
import com.snportela.hair_salon.model.Customer;
import com.snportela.hair_salon.repository.CustomerRepository;
import com.snportela.hair_salon.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findOne(UUID customerId) {
        return customerRepository.findById(customerId).orElseThrow(NotFoundException::new);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(UUID customerId, Customer customer) {
        Customer existingCustomer = customerRepository.findById(customerId).orElseThrow(NotFoundException::new);

        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhone(customer.getPhone());

        return customerRepository.save(existingCustomer);
    }

    @Override
    public void delete(UUID customerId) {
        customerRepository.findById(customerId).orElseThrow(NotFoundException::new);
        customerRepository.deleteById(customerId);
    }
}
