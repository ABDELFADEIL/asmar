package com.aston.ecommerce.asmar.dto;

import com.aston.ecommerce.asmar.entity.AbstractEntity;


public class CommandLineDTO {

    private int quantity;
    private float price;
    private ProductDTO productDTO;
    private OrderDTO orderDTO;
    private UserDTO userDTO;


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

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public OrderDTO getOrderDTO() {
        return orderDTO;
    }

    public void setOrderDTO(OrderDTO orderDTO) {
        this.orderDTO = orderDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    @Override
    public String toString() {
        return "CommandLineDTO{" +
                "quantity=" + quantity +
                ", price=" + price +
                ", productDTO=" + productDTO +
                ", orderDTO=" + orderDTO +
                ", userDTO=" + userDTO +
                '}';
    }
}
