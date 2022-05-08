package gov.iti.jets.repo;

import java.util.List;

import gov.iti.jets.repo.Entities.CartEntity;

public interface CartRepo {

    List<CartEntity> getUserCartByUserId(int userId);

    void deleteUserCart(int id);

    CartEntity updateCart(CartEntity cartEntity, int userId);

    CartEntity saveCart(CartEntity cartEntity,int userId);

    List<CartEntity> getUserCart(int id);

}
