package gov.iti.jets.repo;

import java.util.List;
import gov.iti.jets.repo.Entities.CustomerEntity;

public interface CustomerRepo {

    CustomerEntity saveUser(CustomerEntity user);

    CustomerEntity updateUser(CustomerEntity user);

    CustomerEntity findUserById(int id);

    boolean deleteUser(int id);

    List<CustomerEntity> findAllUsers();

    int getCountOfUsers();
}
