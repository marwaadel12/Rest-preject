package gov.iti.jets.repo.Impl;

import java.util.List;
import gov.iti.jets.repo.CartRepo;
import gov.iti.jets.repo.Entities.AdminEntity;
import gov.iti.jets.repo.Entities.CartEntity;
import gov.iti.jets.repo.Entities.ProductEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;


public class CartRepoImpl implements CartRepo {
    private static CartRepoImpl cartRepoImpl;
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rest");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    private CartRepoImpl() {
    }

    public static CartRepoImpl getInstance() {
        if (cartRepoImpl == null) {
            cartRepoImpl = new CartRepoImpl();

        }
        return cartRepoImpl;
    }

    @Override
    public List<CartEntity> getUserCartByUserId(int userId) {
        Query query = entityManager.createQuery("" +
                "select  c from CartEntity c join c.customer u where  u.id=:user_id", CartEntity.class);
        query.setParameter("user_id",userId);
        List<CartEntity> cartEntityList = (List<CartEntity>) query.getResultList();
        System.out.println(cartEntityList);
        return cartEntityList;
    }

    @Override
    public void deleteUserCart(int id) {
        // TODO Auto-generated method stub

    }

    @Override
    public CartEntity updateCart(CartEntity cartEntity, int userId) {

        CartEntity updatedCart = getUserCartByUserId(userId).get(0);
        updatedCart.setProduct(cartEntity.getProduct());
        updatedCart.setQuantity(cartEntity.getQuantity());
        entityManager.getTransaction().begin();
        CartEntity newCart=entityManager.merge(updatedCart);
        entityManager.getTransaction().commit();
        return newCart;
//        entityManager.getTransaction().begin();
//        entityManager.merge(cartEntity);
//        entityManager.getTransaction().commit();
//       return cartEntity;

    }

    @Override
    public CartEntity saveCart(CartEntity cartEntity, int id) {
        return null;
    }

    @Override
    public List<CartEntity> getUserCart(int id) {
        // TODO Auto-generated method stub
        return null;
    }



}
