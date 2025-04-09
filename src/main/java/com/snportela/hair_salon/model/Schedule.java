package com.snportela.hair_salon.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "schedules")
@Getter
@Setter
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "schedule_id", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID scheduleId;

    @Column(name = "start_at", columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime startAt;

    @Column(name = "end_at", columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime endAt;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
