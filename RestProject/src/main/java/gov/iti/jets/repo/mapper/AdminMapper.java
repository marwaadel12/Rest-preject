package gov.iti.jets.repo.mapper;

import gov.iti.jets.api.admin.AdminDto;
import gov.iti.jets.repo.Entities.AdminEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminMapper {
    AdminMapper instance = Mappers.getMapper(AdminMapper.class);
    AdminDto adminEntityToDto(AdminEntity adminEntity);
    AdminEntity adminDtoToEntity(AdminDto admin);
}

