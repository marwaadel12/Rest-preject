package gov.iti.jets.repo.mapper;

import gov.iti.jets.api.category.CategoryDto;
import gov.iti.jets.repo.Entities.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper instance = Mappers.getMapper(CategoryMapper.class);
    CategoryDto categoryEntityToDto(CategoryEntity categoryEntity);
    CategoryEntity categoryDtoToEntity(CategoryDto categoryDto);
}


