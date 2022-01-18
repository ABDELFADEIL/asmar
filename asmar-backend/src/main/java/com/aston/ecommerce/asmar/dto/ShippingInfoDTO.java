package com.aston.ecommerce.asmar.dto;

import javax.persistence.Column;

public class ShippingInfoDTO {

    private Long id;
    private String shippingType;
    private float shippingCost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
