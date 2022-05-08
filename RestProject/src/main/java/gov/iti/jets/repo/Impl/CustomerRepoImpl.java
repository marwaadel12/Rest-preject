package gov.iti.jets.repo.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;
import gov.iti.jets.repo.CustomerRepo;
import gov.iti.jets.repo.Entities.CustomerEntity;
import jakarta.persistence.Query;

public class CustomerRepoImpl implements CustomerRepo {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rest");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    private static CustomerRepoImpl customerRepoImpl;

    private CustomerRepoImpl() {
    }

    public static CustomerRepoImpl getInstance() {
        if (customerRepoImpl == null) {
            customerRepoImpl = new CustomerRepoImpl();

        }
        return customerRepoImpl;
    }

    @Override
    public CustomerEntity findUserById(int id) {
        TypedQuery<CustomerEntity> query = entityManager.createQuery("SELECT c FROM CustomerEntity c where  c.id = :id",
                CustomerEntity.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public CustomerEntity saveUser(CustomerEntity user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        return user;
    }

    @Override
    public CustomerEntity updateUser(CustomerEntity user) {

        int id = user.getId();
        CustomerEntity updatedUser = findUserById(id);
        updatedUser.setUserName(user.getUserName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setPass(user.getPass());
        entityManager.getTransaction().begin();
        entityManager.merge(updatedUser);
        entityManager.getTransaction().commit();
        return updatedUser;

    }

    @Override
    public boolean deleteUser(int id) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("DELETE c FROM CustomerEntity c WHERE c.id like :id");
        query.setParameter("id", id);
        if (query.executeUpdate() == 1) {
            entityManager.getTransaction().commit();
            return true;
        } else {
            return false;
        }

    }

    @Override
    public List<CustomerEntity> findAllUsers() {

        List<CustomerEntity> resultList = (List<CustomerEntity>) entityManager
                .createQuery("SELECT c FROM CustomerEntity c").getResultList();
        return resultList;
    }

    @Override
    public int getCountOfUsers() {

        Query queryTotal = entityManager.createQuery("Select count(p) from p");
        long countResult = (long) queryTotal.getSingleResult();
        return (int) countResult;
    }

}
