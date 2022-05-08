package gov.iti.jets.repo;

import java.util.List;

import gov.iti.jets.repo.Entities.AdminEntity;

public interface AdminRepo {

    List<AdminEntity> getAllAdmins();
}
