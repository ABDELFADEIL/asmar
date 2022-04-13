package com.aston.ecommerce.asmar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "shipping_info")
public class ShippingInfo extends AbstractEntity{

    @Column(name="shipping_type", nullable = false)
    private String shippingType;
    @Column(name="shipping_cost", nullable = false)
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
}
