package gov.iti.jets.repo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import gov.iti.jets.api.products.ProductDto;
import gov.iti.jets.repo.Entities.ProductEntity;

@Mapper
public interface ProductMapper {
    ProductMapper instance = Mappers.getMapper(ProductMapper.class);
    ProductDto productEntityToDto(ProductEntity productEntity);
    ProductEntity productDtoToEntity(ProductDto productDto);
}



