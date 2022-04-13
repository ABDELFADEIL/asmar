package com.aston.ecommerce.asmar.dto;




public class ProductToCartDTO {

    private Long productId;
    private Long userId;
    private int quantity;

    public ProductToCartDTO() {
    }

    public ProductToCartDTO(Long productId, Long userId, int quantity) {
        this.productId = productId;
        this.userId = userId;
        this.quantity = quantity;
    }


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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
