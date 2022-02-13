package com.aston.ecommerce.asmar.dto;

import com.aston.ecommerce.asmar.entity.Product;
import com.aston.ecommerce.asmar.entity.User;


public class addProductToCartDTO {

    private Long product_id;
    private Product product;
    private Long user_id;
    private User user;
    private int quantity;


    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "addProductToCartDTO{" +
                "product_id=" + product_id +
                ", product=" + product +
                ", user_id=" + user_id +
                ", user=" + user +
                ", quantity=" + quantity +
                '}';
    }
}
