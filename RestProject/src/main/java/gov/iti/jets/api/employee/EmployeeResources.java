package gov.iti.jets.api.employee;

import gov.iti.jets.api.employee.model.EmployeeDto;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("employees")
public class EmployeeResources {

    @GET
    @Produces({MediaType.TEXT_PLAIN,"text/emp"})
    public EmployeeDto needsMsgBodyWriter() {
        EmployeeDto employee = new EmployeeDto(1, "marwa", 22);
        return employee;
    }
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public void needsMsgBodyReader(EmployeeDto employee) {
        System.out.println(employee);
    }
        
}
