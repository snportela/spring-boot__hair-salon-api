package com.snportela.hair_salon.service;

import com.snportela.hair_salon.model.Schedule;

import java.util.List;
import java.util.UUID;

public interface ScheduleService {

    List<Schedule> findAll();

    Schedule findOne(UUID scheduleId);

    Schedule save(Schedule schedule);

    Schedule update(UUID scheduleId, Schedule schedule);

    void delete(UUID scheduleId);
}
