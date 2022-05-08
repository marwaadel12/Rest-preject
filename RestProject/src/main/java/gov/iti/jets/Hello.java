package gov.iti.jets;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("Hi")
public class Hello{
   
    @GET
    public String getHello() {
        return "HI";
    }

    @GET
    @Path("sec")
    public String getNumber() {
        return "My name is marwa ";
    }
}
