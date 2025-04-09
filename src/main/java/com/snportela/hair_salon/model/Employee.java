package com.snportela.hair_salon.model;

import com.snportela.hair_salon.enums.EmployeeRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "employees")
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID employeeId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EmployeeRole role;
}
