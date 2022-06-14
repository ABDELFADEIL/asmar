package com.aston.ecommerce.asmar.dto;




public class ProductToCartDTO {

    private Integer productId;
    private Integer userId;
    private int quantity;

    public ProductToCartDTO() {
    }

    public ProductToCartDTO(Integer productId, Integer userId, int quantity) {
        this.productId = productId;
        this.userId = userId;
        this.quantity = quantity;
    }


    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ProductToCartDTO{" +
                "productId=" + productId +
                ", userId=" + userId +
                ", quantity=" + quantity +
                '}';
    }
}
