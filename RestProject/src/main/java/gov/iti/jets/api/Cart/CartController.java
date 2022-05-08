package gov.iti.jets.api.Cart;

import gov.iti.jets.api.customer.CustomerDto;
import gov.iti.jets.repo.CartRepo;
import gov.iti.jets.repo.CustomerRepo;
import gov.iti.jets.repo.Entities.CartEntity;
import gov.iti.jets.repo.Entities.CustomerEntity;
import gov.iti.jets.repo.Impl.CartRepoImpl;
import gov.iti.jets.repo.Impl.CustomerRepoImpl;
import gov.iti.jets.repo.mapper.CartMapper;
import gov.iti.jets.repo.mapper.CategoryMapper;
import gov.iti.jets.repo.mapper.CustomerMapper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;
@Path("carts")
public class CartController {
    CartRepo cartRepo = CartRepoImpl.getInstance();

    @GET
    @Path("{id}")
    public List<CartDto> getUserCarts(@PathParam("id") int id) {

        List<CartDto> cartList = new ArrayList<>();
        for(CartEntity cartEntity : cartRepo.getUserCartByUserId(id) ){
            cartList.add(CartMapper.instance.cartEntityToDto(cartEntity));
        }
        return cartList;

      
    }
   
}
