package com.snportela.hair_salon.mapper;

import com.snportela.hair_salon.dto.CustomerDto;
import com.snportela.hair_salon.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

    CustomerDto toDto(Customer customer);

    Customer fromDto(CustomerDto customerDto);
}
