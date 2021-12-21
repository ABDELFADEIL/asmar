package com.aston.ecommerce.asmar.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "shipping_info")
public class ShippingInfo extends AbstractEntity{

    @Column(name="shipping_type")
    @NotNull
    @NotEmpty
    private String shippingType;
    @Column(name="shipping_cost")
    @NotNull
    @NotEmpty
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
