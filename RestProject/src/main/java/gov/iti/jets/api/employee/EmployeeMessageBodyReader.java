package gov.iti.jets.api.employee;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import gov.iti.jets.api.employee.model.EmployeeDto;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.MessageBodyReader;
import jakarta.ws.rs.ext.Provider;


@Provider
@Consumes(MediaType.TEXT_PLAIN)
public class EmployeeMessageBodyReader implements MessageBodyReader<EmployeeDto> {

    @Override
    public boolean isReadable(Class<?> type, Type arg1, Annotation[] arg2, MediaType arg3) {
        return EmployeeDto.class.isAssignableFrom(type);
    }

    @Override
    public EmployeeDto readFrom(Class<EmployeeDto> arg0, Type arg1, Annotation[] arg2, MediaType arg3,
            MultivaluedMap<String, String> arg4, InputStream entityStream) throws IOException, WebApplicationException {
                String empStr = new String(entityStream.readAllBytes());
                empStr = empStr.trim();
                empStr = empStr.replace("Employee [", "");
                empStr = empStr.replace("]", "");
                String[] values = empStr.split(", ");
                int id = Integer.parseInt(values[0].replace("id=", ""));
                String name = values[1].replace("name=", "");
                int age = Integer.parseInt(values[2].replace("age=", ""));
                return new EmployeeDto(id, name, age); 
    }
    
}
