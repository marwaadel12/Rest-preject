package gov.iti.jets.repo.mapper;

import gov.iti.jets.api.Cart.CartDto;
import gov.iti.jets.api.admin.AdminDto;
import gov.iti.jets.repo.Entities.AdminEntity;
import gov.iti.jets.repo.Entities.CartEntity;
import gov.iti.jets.repo.Entities.CartID;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartMapper {
    CartMapper instance = Mappers.getMapper(CartMapper.class);
    CartDto cartEntityToDto(CartEntity cartEntity);
    CartEntity cartDtoToEntity(CartDto cart);
}
