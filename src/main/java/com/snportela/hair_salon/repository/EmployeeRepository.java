package com.snportela.hair_salon.repository;

import com.snportela.hair_salon.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}
