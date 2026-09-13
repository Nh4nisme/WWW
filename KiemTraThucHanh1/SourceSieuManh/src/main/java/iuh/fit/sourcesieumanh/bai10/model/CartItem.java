package iuh.fit.sourcesieumanh.bai10.model;


import java.io.Serializable;
import java.math.BigDecimal;

public class CartItem implements Serializable {


    private final Product product;
    private int quantity;

    public CartItem(Product product) {
        this.product = product;
        this.quantity = 1;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }

    public BigDecimal getSubtotal() {
        return product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    public void increaseQuantity() {
        this.quantity++;
    }
}
