package com.snportela.hair_salon.repository;

import com.snportela.hair_salon.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ScheduleRepository extends JpaRepository<Schedule, UUID> {
}
