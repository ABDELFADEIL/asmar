package com.aston.ecommerce.asmar.dto;

import javax.persistence.Column;

public class ShippingInfoDTO {

    private String shippingType;
    private float shippingCost;

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
                "shippingType='" + shippingType + '\'' +
                ", shippingCost=" + shippingCost +
                '}';
    }
}
