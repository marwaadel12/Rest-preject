package gov.iti.jets.repo.mapper;

import gov.iti.jets.api.customer.CustomerDto;
import gov.iti.jets.repo.Entities.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper instance = Mappers.getMapper(CustomerMapper.class);
    CustomerDto customerEntityToDto(CustomerEntity customerEntity);
    CustomerEntity customerDtoToEntity(CustomerDto customerDto);
}



