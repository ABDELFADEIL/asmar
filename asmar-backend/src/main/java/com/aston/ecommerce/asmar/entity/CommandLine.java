package com.aston.ecommerce.asmar.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "commandLine")
public class CommandLine extends AbstractEntity{

    @Column(name="quantity")
    @NotNull
    @NotEmpty
    private int quantity;

    @Column(name="price")
    @NotNull
    @NotEmpty
    private float price;
    @ManyToOne
    @JoinColumn(name="productId")
    private Product product;
    @ManyToOne
    @JoinColumn(name="orderId")
    private Order order;
    @ManyToOne
    @JoinColumn(name="shoppingCartId")
    private ShoppingCart shoppingCart;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
