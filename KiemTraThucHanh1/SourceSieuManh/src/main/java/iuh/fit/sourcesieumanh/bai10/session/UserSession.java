package iuh.fit.sourcesieumanh.bai10.session;

import iuh.fit.sourcesieumanh.bai10.service.ShoppingCart;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("userSession")
@SessionScoped
public class UserSession implements Serializable {
    private String username;
    private final ShoppingCart shoppingCart = new ShoppingCart();

    public void login(String username) { this.username = username; }
    public boolean isLoggedIn() { return username != null; }
    public String getUsername() { return username; }
    public ShoppingCart getShoppingCart() { return shoppingCart; }
}
