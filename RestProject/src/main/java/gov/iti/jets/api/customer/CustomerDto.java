
package gov.iti.jets.api.customer;

import gov.iti.jets.api.Cart.CartDto;
import gov.iti.jets.api.order.OrderDetailsDto;
import gov.iti.jets.repo.Entities.CartEntity;
import gov.iti.jets.repo.Entities.OrderDetailsEntity;

import java.io.Serializable;
import java.util.Set;

public class CustomerDto implements Serializable {

    private int id;
    private String userName;
    private String email;
    private String pass;
    private Set<CartDto> cart;
    private Set<OrderDetailsDto> orderDetails;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Set<CartDto> getCart() {
        return cart;
    }

    public void setCart(Set<CartDto> cart) {
        this.cart = cart;
    }

    public Set<OrderDetailsDto> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetailsDto> orderDetails) {
        this.orderDetails = orderDetails;
    }

}
