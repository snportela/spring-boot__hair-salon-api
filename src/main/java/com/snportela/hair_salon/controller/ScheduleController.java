package com.snportela.hair_salon.controller;

import com.snportela.hair_salon.dto.ScheduleDto;
import com.snportela.hair_salon.mapper.ScheduleMapper;
import com.snportela.hair_salon.model.Schedule;
import com.snportela.hair_salon.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    private final ScheduleMapper scheduleMapper;

    public ScheduleController(ScheduleService scheduleService, ScheduleMapper scheduleMapper) {
        this.scheduleService = scheduleService;
        this.scheduleMapper = scheduleMapper;
    }

    @GetMapping
    public ResponseEntity<List<ScheduleDto>> listSchedules() {
        List<ScheduleDto> scheduleDtoList = scheduleService.findAll().stream().map(scheduleMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(scheduleDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleDto> getSchedule(@PathVariable("id") UUID scheduleId) {
        Schedule foundSchedule = scheduleService.findOne(scheduleId);
        return ResponseEntity.status(HttpStatus.OK).body(scheduleMapper.toDto(foundSchedule));
    }

    @PostMapping
    public ResponseEntity<ScheduleDto> createSchedule(@RequestBody ScheduleDto scheduleDto) {
        Schedule savedSchedule = scheduleService.save(scheduleMapper.fromDto(scheduleDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleMapper.toDto(savedSchedule));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScheduleDto> updateSchedule(
            @PathVariable("id") UUID scheduleId, @RequestBody ScheduleDto scheduleDto
    ) {
        Schedule updatedSchedule = scheduleService.update(scheduleId, scheduleMapper.fromDto(scheduleDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleMapper.toDto(updatedSchedule));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSchedule(@PathVariable("id") UUID scheduleId) {
        scheduleService.delete(scheduleId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted schedule with ID: " + scheduleId);
    }

}
