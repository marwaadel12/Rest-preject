package gov.iti.jets.repo.Impl;

import gov.iti.jets.repo.ProductRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;
import gov.iti.jets.repo.Entities.ProductEntity;

public class ProductRepoImpl implements ProductRepo {

    private static ProductRepoImpl productRepoImpl;

    private ProductRepoImpl() {
    }

    public static ProductRepoImpl getInstance() {
        if (productRepoImpl == null) {
            productRepoImpl = new ProductRepoImpl();

        }
        return productRepoImpl;
    }

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rest");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public List<ProductEntity> findAllProductByCategoryId(int id) {
        TypedQuery<ProductEntity> query = entityManager.createNamedQuery("select p from ProductEntity p where p.category.categoryId like :category_id", ProductEntity.class);
        query.setParameter("category_id", id);
        return query.getResultList();
    }

    @Override
    public List<ProductEntity> findProductByName(String productName) {

        TypedQuery<ProductEntity> query = entityManager.createQuery("select p from ProductEntity p   where  p.name  LIKE : product_name", ProductEntity.class);
        query.setParameter("product_name","%"+ productName+"%");
        return query.getResultList();
    }

    @Override
    public List<ProductEntity> findProductByPrice(double productPrice) {

        TypedQuery<ProductEntity> query = entityManager.createQuery("select p from ProductEntity p   where  p.price  = :product_price OR p.price  < :product_price", ProductEntity.class);
        query.setParameter("product_price", productPrice);
        return query.getResultList();

    }

    @Override
    public List<ProductEntity> findAllProducts() {

        List<ProductEntity> resultList = (List<ProductEntity>) entityManager.createQuery("SELECT p FROM ProductEntity p").getResultList();
        return resultList;
    }

    @Override
    public ProductEntity saveProduct(ProductEntity product) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();
        return product;
    }

    @Override
    public ProductEntity updateProduct(ProductEntity product) {
        EntityManager em = entityManagerFactory.createEntityManager();
        long id = product.getId();
        ProductEntity updatedProduct =  findProductById(id);
        updatedProduct.setDescription(product.getDescription());
        updatedProduct.setPrice(product.getPrice());
        updatedProduct.setQuantity(product.getQuantity());
        updatedProduct.setName(product.getName());

        em.getTransaction().begin();
        em.merge(updatedProduct);
        em.getTransaction().commit();
        return updatedProduct;
    }

    @Override
    public ProductEntity findProductById(long id) {

        TypedQuery<ProductEntity> query = entityManager.createQuery("select p from ProductEntity p where  p.id = :id", ProductEntity.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public boolean deleteProduct(long id) {
        entityManager.getTransaction().begin();

       Query query = entityManager.createQuery("DELETE FROM ProductEntity p WHERE p.id like :id").setParameter("id",id);

       if(query.executeUpdate()==1){
           entityManager.getTransaction().commit();;
           return true;
       }
       return false;
    }

    @Override
    public int getCountOfProducts() {
        Query queryTotal = entityManager.createQuery("Select count(p) from p");
        long countResult = (long) queryTotal.getSingleResult();
        return (int) countResult;
    }

}
