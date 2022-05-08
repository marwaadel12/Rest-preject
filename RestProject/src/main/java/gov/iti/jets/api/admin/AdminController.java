package gov.iti.jets.api.admin;

import gov.iti.jets.api.admin.AdminDto;
import gov.iti.jets.repo.AdminRepo;
import gov.iti.jets.repo.Entities.AdminEntity;
import gov.iti.jets.repo.Impl.AdminRepoImpl;
import gov.iti.jets.repo.mapper.AdminMapper;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Path("admins")
public class AdminController {
    AdminRepo adminRepo = AdminRepoImpl.getInstance();
    @GET
    public Response getAllCustomers(){



        List<AdminDto> adminList = new ArrayList<>();
        for(AdminEntity adminEntity : adminRepo.getAllAdmins() ){
            adminList.add(AdminMapper.instance.adminEntityToDto(adminEntity));
        }

        GenericEntity entity = new GenericEntity<List<AdminDto>>(adminList){};
        return Response.ok(entity).build();
    }


}