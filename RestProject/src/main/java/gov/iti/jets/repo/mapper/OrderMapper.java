 package gov.iti.jets.repo.mapper;


 import gov.iti.jets.api.order.OrderDto;
 import gov.iti.jets.repo.Entities.OrderEntity;
 import org.mapstruct.Mapper;
 import org.mapstruct.factory.Mappers;

 @Mapper
 public interface OrderMapper {
     OrderMapper instance = Mappers.getMapper(OrderMapper.class);
     OrderDto orderEntityToDto(OrderEntity orderEntity);
     OrderEntity orderDtoToEntity(OrderDto OrderDto);
 }



