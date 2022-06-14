package com.aston.ecommerce.asmar.dto;


public class ShippingInfoDTO {

    private Integer id;
    private String shippingType;
    private float shippingCost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }

    public float getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(float shippingCost) {
        this.shippingCost = shippingCost;
    }

    @Override
    public String toString() {
        return "ShippingInfoDTO{" +
                "id=" + id +
                ", shippingType='" + shippingType + '\'' +
                ", shippingCost=" + shippingCost +
                '}';
    }
}
