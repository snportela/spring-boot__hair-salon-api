package com.snportela.hair_salon.dto;

import com.snportela.hair_salon.enums.EmployeeRole;

import java.util.UUID;

public record EmployeeDto(

        UUID employeeId,

        String name,

        String email,

        String phone,

        EmployeeRole role
) {
}
