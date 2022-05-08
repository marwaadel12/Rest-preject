package gov.iti.jets.repo;

import java.math.BigDecimal;
import java.util.List;
import gov.iti.jets.repo.Entities.ProductEntity;

public interface ProductRepo {

    List<ProductEntity> findAllProductByCategoryId(int id);

    List<ProductEntity> findProductByName(String productName);

    List<ProductEntity> findProductByPrice(double productPrice);

    List<ProductEntity> findAllProducts();

    ProductEntity saveProduct(ProductEntity product);

    ProductEntity updateProduct(ProductEntity product);

   ProductEntity findProductById(long id);

    boolean deleteProduct(long id);

    int getCountOfProducts();
}
