package gov.iti.jets.repo;

import java.util.List;

import gov.iti.jets.repo.Entities.CategoryEntity;
import gov.iti.jets.repo.Entities.ProductEntity;

public interface CategoryRepo {

    CategoryEntity saveCategory(CategoryEntity category);

    boolean deleteCategory(int id);

    CategoryEntity findCategoryById(int id);

    List<CategoryEntity> findAllCategory();

    CategoryEntity updateCategory(CategoryEntity entity);

    List<ProductEntity>getAllProductsByCatgeoryId(int id);

    int getCountOfCategory();
}
