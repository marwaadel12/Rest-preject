package gov.iti.jets.api.employee;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import gov.iti.jets.api.employee.model.EmployeeDto;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.MessageBodyWriter;
import jakarta.ws.rs.ext.Provider;

@Provider
@Consumes({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
@Produces("text/emp")
public class EmployeeMessageBodyWriter implements MessageBodyWriter<EmployeeDto> {

    @Override
    public boolean isWriteable(Class<?> type, Type arg1, Annotation[] arg2, MediaType arg3) {
        return EmployeeDto.class.isAssignableFrom(type);
    }

    @Override
    public void writeTo(EmployeeDto employee, Class arg1, Type arg2, Annotation[] arg3, MediaType arg4,
            MultivaluedMap arg5,
            OutputStream entityStream) throws IOException, WebApplicationException {
        String customEmp = " Our Employee are " + employee.toString();
        entityStream.write(customEmp.getBytes());
    }

}
