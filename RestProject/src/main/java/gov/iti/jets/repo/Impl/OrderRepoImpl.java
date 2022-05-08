package gov.iti.jets.repo.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import gov.iti.jets.repo.OrderRepo;
import gov.iti.jets.repo.Entities.OrderEntity;
import java.util.List;

public class OrderRepoImpl implements OrderRepo {

    private static OrderRepoImpl OrderRepoImpl;

    private OrderRepoImpl() {
    }

    public static OrderRepoImpl getInstance() {
        if (OrderRepoImpl == null) {
            OrderRepoImpl = new OrderRepoImpl();

        }
        return OrderRepoImpl;
    }

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rest");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public List<OrderEntity> findAllByUserId(int userId) {

        TypedQuery<OrderEntity> query = entityManager.createQuery("select  o from OrderEntity o join o.orderDetails od where  od.user.id=:user_id", OrderEntity.class);
        query.setParameter("user_id", userId);
        return query.getResultList();
    }

    @Override
    public List<OrderEntity> getAllUserOrder(String email) {

        Query queryTotal = entityManager
                .createQuery("Select p from OrderEntity p where p.email=  " + "'" + email + "'");
        List<OrderEntity> orderEntityList = queryTotal.getResultList();
        return orderEntityList;
    }

    @Override
    public OrderEntity findOrderById(int id) {
        TypedQuery<OrderEntity> query = entityManager.createQuery("select  o from OrderEntity o join o.orderDetails od where  od.user.id=:id",
                OrderEntity.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public OrderEntity updateOrder(OrderEntity order) {
        EntityManager em = entityManagerFactory.createEntityManager();

        int id = order.getId();
        OrderEntity updateOrder = findOrderById(id);
        updateOrder.setDescription(order.getDescription());
        updateOrder.setEmail(order.getEmail());
        updateOrder.setPhoneNumber(order.getPhoneNumber());
        updateOrder.setTotalPrice(order.getTotalPrice());
        updateOrder.setOrderDetails(order.getOrderDetails());
        em.getTransaction().begin();
        OrderEntity userUpdated = em.merge(updateOrder);
        em.getTransaction().commit();
        System.out.println(userUpdated);
        return userUpdated;

    }

    @Override
    public boolean deleteOrder(int id) {
        entityManager.getTransaction().begin();
        Query query = entityManager
                .createQuery("DELETE FROM OrderEntity c WHERE c.id like :id");
        query.setParameter("id", id);
        if (query.executeUpdate() == 1) {
            entityManager.getTransaction().commit();
            return true;
        } else {
            return false;
        }

    }

    @Override
    public OrderEntity saveOrder(OrderEntity order) {
        entityManager.getTransaction().begin();
        entityManager.persist(order);
        entityManager.getTransaction().commit();
        return order;
    }
}
