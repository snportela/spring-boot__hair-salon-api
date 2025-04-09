package com.snportela.hair_salon.mapper;

import com.snportela.hair_salon.dto.EmployeeDto;
import com.snportela.hair_salon.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper {

    EmployeeDto toDto(Employee employee);

    Employee fromDto(EmployeeDto employeeDto);

}
