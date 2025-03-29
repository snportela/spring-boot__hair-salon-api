package com.snportela.hair_salon.service;

import com.snportela.hair_salon.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    List<Customer> findAll();

    Customer findOne(UUID customerId);

    Customer save(Customer customer);

    Customer update(UUID customerId, Customer customer);

    void delete(UUID customerId);
}
