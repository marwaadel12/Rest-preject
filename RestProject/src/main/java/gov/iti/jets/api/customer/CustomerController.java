package gov.iti.jets.api.customer;

import java.util.ArrayList;
import java.util.List;
import gov.iti.jets.repo.CustomerRepo;
import gov.iti.jets.repo.Entities.CustomerEntity;
import gov.iti.jets.repo.Impl.CustomerRepoImpl;
import gov.iti.jets.repo.mapper.CustomerMapper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("customers")
public class CustomerController {

    CustomerRepo customerRepo = CustomerRepoImpl.getInstance();

    @GET
    public List<CustomerDto> getAllCustomer() {
      
        List<CustomerDto> customerList = new ArrayList<>();
        for (CustomerEntity customerEntity : customerRepo.findAllUsers()) {
            System.out.println("qqqqqqqqqqqqqqqqqqqq " + CustomerMapper.instance.customerEntityToDto(customerEntity));
            customerList.add(CustomerMapper.instance.customerEntityToDto(customerEntity));
        }
        return customerList;

        
    }

    @GET
    @Path("{id}")
    public CustomerDto getCustomerById(@PathParam("id") int id) {
       
        System.out.println(customerRepo.findUserById(id));
        CustomerDto customerDto = CustomerMapper.instance.customerEntityToDto(customerRepo.findUserById(id));
        return customerDto;


    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("customer")
    public CustomerDto updateCustomer(CustomerDto customerDto) {
        CustomerDto updatedCustomer = CustomerMapper.instance.customerEntityToDto(
                customerRepo.updateUser(CustomerMapper.instance.customerDtoToEntity(customerDto)));
        return updatedCustomer;
    }

    @DELETE
    @Path("{id}")
    public boolean deleteCustomer(@PathParam("id") int id) {
        boolean deleted = customerRepo.deleteUser(id);
        return deleted;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public CustomerDto addCustomer(CustomerDto customerDto) {
        CustomerDto addedCustomer = CustomerMapper.instance.customerEntityToDto(
                customerRepo.saveUser(CustomerMapper.instance.customerDtoToEntity(customerDto)));
        return addedCustomer;
    }

}
