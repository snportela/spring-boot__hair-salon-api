package com.snportela.hair_salon.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record ScheduleDto(

        UUID ScheduleId,

        LocalDateTime startAt,

        LocalDateTime endAt,

        CustomerDto customer
) {
}
