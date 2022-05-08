package gov.iti.jets.repo.Impl;

import gov.iti.jets.repo.AdminRepo;
import gov.iti.jets.repo.Entities.AdminEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class AdminRepoImpl implements AdminRepo {
    private static AdminRepoImpl adminRepoImpl;

    private AdminRepoImpl() {
    }

    public static AdminRepoImpl getInstance() {
        if (adminRepoImpl == null) {
            adminRepoImpl = new AdminRepoImpl();

        }
        return adminRepoImpl;
    }

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rest");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
    public List<AdminEntity> getAllAdmins() {
        Query query = entityManager.createQuery("select u from AdminEntity u ", AdminEntity.class);
        List<AdminEntity> adminEntityList = (List<AdminEntity>) query.getResultList();
        return adminEntityList;
    }

}
