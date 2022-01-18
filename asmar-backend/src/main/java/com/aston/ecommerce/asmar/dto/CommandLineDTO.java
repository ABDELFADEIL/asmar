package com.aston.ecommerce.asmar.dto;

import com.aston.ecommerce.asmar.entity.AbstractEntity;


public class CommandLineDTO {

    private Long id;
    private int quantity;
    private float price;
    private ProductDTO product;
    private OrderDTO order;
    private UserDTO user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "CommandLineDTO{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                ", product=" + product +
                ", order=" + order +
                ", user=" + user +
                '}';
    }
}
