package com.snportela.hair_salon.dto;

import java.util.UUID;

public record CustomerDto(

        UUID customerId,

        String name,

        String email,

        String phone
) {
}
