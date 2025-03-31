package com.snportela.hair_salon.mapper;

import com.snportela.hair_salon.dto.ScheduleDto;
import com.snportela.hair_salon.model.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ScheduleMapper {

    ScheduleDto toDto(Schedule schedule);

    Schedule fromDto(ScheduleDto scheduleDto);
}