package gov.iti.jets.repo.mapper;

import gov.iti.jets.api.order.OrderDetailsDto;
import gov.iti.jets.repo.Entities.OrderDetailsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderDetailsMapper {
    OrderDetailsMapper instance = Mappers.getMapper(OrderDetailsMapper.class);
    OrderDetailsDto orderDetailsEntityToDto(OrderDetailsEntity orderDetailsEntity);
    OrderDetailsEntity orderDetailsDtoToEntity(OrderDetailsDto orderDetailsDto);
}



