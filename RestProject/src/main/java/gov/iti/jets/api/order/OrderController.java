package gov.iti.jets.api.order;

import gov.iti.jets.api.products.ProductDto;
import gov.iti.jets.repo.Entities.OrderEntity;
import gov.iti.jets.repo.Entities.ProductEntity;
import gov.iti.jets.repo.Impl.OrderRepoImpl;
import gov.iti.jets.repo.Impl.ProductRepoImpl;
import gov.iti.jets.repo.OrderRepo;
import gov.iti.jets.repo.ProductRepo;
import gov.iti.jets.repo.mapper.OrderMapper;
import gov.iti.jets.repo.mapper.ProductMapper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("orders")
public class OrderController {

    OrderRepo orderRepo = OrderRepoImpl.getInstance();

    @GET
    @Path("order/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrderDto> getAllProductsByUserId(@PathParam("id") int id) {
        List<OrderDto> orderList = new ArrayList<>();
        for (OrderEntity orderEntity : orderRepo.findAllByUserId(id)) {
            orderList.add(OrderMapper.instance.orderEntityToDto(orderEntity));
        }
        return orderList;
    }

    @GET
    @Path("orderId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public OrderDto getOrderById(@PathParam("id") int id) {
        OrderDto productDto = OrderMapper.instance.orderEntityToDto(orderRepo.findOrderById(id));
        System.out.println(productDto);
        return productDto;

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("putOrder")
    public OrderDto updateOrder(OrderDto orderDto) {
        OrderDto updatedOrder = OrderMapper.instance.orderEntityToDto(
                orderRepo.updateOrder(OrderMapper.instance.orderDtoToEntity(orderDto)));
        return updatedOrder;
    }

    @DELETE
    @Path("{id}")
    public boolean deleteOrder(@PathParam("id") int id) {
        boolean deleted = orderRepo.deleteOrder(id);
        return deleted;
    }

    @POST
    @Path("postOrder")
    @Consumes(MediaType.APPLICATION_JSON)
    public OrderDto addCustomer(OrderDto orderDto) {
        OrderDto addedOrder = OrderMapper.instance.orderEntityToDto(
                orderRepo.saveOrder(OrderMapper.instance.orderDtoToEntity(orderDto)));
        return addedOrder;
    }

}