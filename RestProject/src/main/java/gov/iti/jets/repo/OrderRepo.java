package gov.iti.jets.repo;

import java.util.List;
import gov.iti.jets.repo.Entities.OrderEntity;

public interface OrderRepo {

    List<OrderEntity> findAllByUserId(int userId);

    List<OrderEntity> getAllUserOrder(String email);

    boolean deleteOrder(int id);

    OrderEntity saveOrder(OrderEntity order);

    OrderEntity findOrderById(int id);

    OrderEntity updateOrder(OrderEntity order);
}
