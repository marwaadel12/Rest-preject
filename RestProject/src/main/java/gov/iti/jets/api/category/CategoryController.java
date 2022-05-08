package gov.iti.jets.api.category;

import java.util.ArrayList;
import java.util.List;

import gov.iti.jets.api.category.CategoryDto;
import gov.iti.jets.api.products.ProductDto;
import gov.iti.jets.repo.CategoryRepo;
import gov.iti.jets.repo.CustomerRepo;
import gov.iti.jets.repo.Entities.CategoryEntity;
import gov.iti.jets.repo.Entities.CustomerEntity;
import gov.iti.jets.repo.Entities.ProductEntity;
import gov.iti.jets.repo.Impl.CategoryRepoImpl;
import gov.iti.jets.repo.Impl.CustomerRepoImpl;
import gov.iti.jets.repo.mapper.CategoryMapper;
import gov.iti.jets.repo.mapper.CustomerMapper;
import gov.iti.jets.repo.mapper.ProductMapper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("categories")
public class CategoryController {

    CategoryRepo categoryRepo = CategoryRepoImpl.getInstance();

    @GET
    public List<CategoryDto> getAllCategories() {
        //Marwa
        List<CategoryDto> categoryList = new ArrayList<>();
        for(CategoryEntity categoryEntity : categoryRepo.findAllCategory() ){
            categoryList.add(CategoryMapper.instance.categoryEntityToDto(categoryEntity));
        }
        return categoryList;



    }


    @GET
    @Path("{id}")
    public CategoryDto getCategoryById(@PathParam("id") int id) {
        //marwa

        CategoryDto categoryDto = CategoryMapper.instance.categoryEntityToDto(categoryRepo.findCategoryById(id));
        return categoryDto;


    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public CategoryDto updateCustomer(CategoryDto categoryDto){
        CategoryDto updatedCategory = CategoryMapper.instance.categoryEntityToDto(
                categoryRepo.updateCategory(CategoryMapper.instance.categoryDtoToEntity(categoryDto)));
        return updatedCategory;
    }

    @DELETE
    @Path("{id}")
    public boolean deleteCategory(@PathParam("id") int id){
        boolean deleted = categoryRepo.deleteCategory(id);
        return deleted;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public CategoryDto addCategory(CategoryDto categoryDto){
        CategoryDto addedCategory = CategoryMapper.instance.categoryEntityToDto(
                categoryRepo.saveCategory(CategoryMapper.instance.categoryDtoToEntity(categoryDto)));
        return addedCategory;
    }

    @GET
    @Path("products/{id}")
    public List<ProductDto> getAllProductsForCategory(@PathParam("id") int id){
        List<ProductDto> productList = new ArrayList<>();
        for(ProductEntity productEntity : categoryRepo.getAllProductsByCatgeoryId(id) ){
            productList.add(ProductMapper.instance.productEntityToDto(productEntity));
        }
        return productList;

    }


}