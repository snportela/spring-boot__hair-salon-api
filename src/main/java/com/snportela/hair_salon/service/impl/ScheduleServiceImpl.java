package com.snportela.hair_salon.service.impl;

import com.snportela.hair_salon.exception.NotFoundException;
import com.snportela.hair_salon.model.Schedule;
import com.snportela.hair_salon.repository.ScheduleRepository;
import com.snportela.hair_salon.service.ScheduleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule findOne(UUID scheduleId) {
        return scheduleRepository.findById(scheduleId).orElseThrow(NotFoundException::new);
    }

    @Override
    public Schedule save(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public Schedule update(UUID scheduleId, Schedule schedule) {
        Schedule existingSchedule = scheduleRepository.findById(scheduleId).orElseThrow(NotFoundException::new);

        existingSchedule.setStartAt(schedule.getStartAt());
        existingSchedule.setEndAt(schedule.getEndAt());
        existingSchedule.setCustomer(schedule.getCustomer());
        existingSchedule.setEmployee(schedule.getEmployee());

        return scheduleRepository.save(existingSchedule);

    }

    @Override
    public void delete(UUID scheduleId) {
        scheduleRepository.findById(scheduleId).orElseThrow(NotFoundException::new);
        scheduleRepository.deleteById(scheduleId);
    }
}
