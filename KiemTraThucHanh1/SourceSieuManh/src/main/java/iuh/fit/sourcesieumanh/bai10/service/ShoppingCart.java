package iuh.fit.sourcesieumanh.bai10.service;

import iuh.fit.sourcesieumanh.bai10.model.CartItem;
import iuh.fit.sourcesieumanh.bai10.model.Product;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCart implements Serializable {

    private final List<CartItem> items = new ArrayList<>();

    public void add(Product product) {
        items.stream()
                .filter(item -> item.getProduct().getId() == product.getId())
                .findFirst()
                .ifPresentOrElse(
                        CartItem::increaseQuantity,
                        () -> items.add(new CartItem(product))
                );
    }

    public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public int getItemCount() {
        return items.stream().mapToInt(CartItem::getQuantity).sum();
    }

    public BigDecimal getTotal() {
        return items.stream()
                .map(CartItem::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}