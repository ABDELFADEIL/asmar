package com.aston.ecommerce.asmar.dto;

import java.math.BigDecimal;

public class CommandLineDTO {

    private Integer id;
    private float price;
    private  BigDecimal subTotal;
    private ProductDTO product;
    private Long orderId;
    private UserDTO user;
    private int quantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductDTO getProduct() {  return product; }

    public void setProduct(ProductDTO product) { this.product = product;}

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }


    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity;
    }

    public float getPrice() {  return price;  }

    public void setPrice(float price) { this.price = price; }

    public BigDecimal getSubTotal() {  return subTotal;  }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }


    @Override
    public String toString() {
        return "CommandLineDTO{" +
                "id=" + id +
                ", price=" + price +
                ", subTotal=" + subTotal +
                ", product=" + product +
                ", orderId=" + orderId +
                ", user=" + user +
                ", quantity=" + quantity +
                '}';
    }
}
