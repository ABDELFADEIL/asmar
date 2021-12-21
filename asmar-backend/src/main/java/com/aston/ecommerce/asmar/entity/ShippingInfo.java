package com.aston.ecommerce.asmar.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "shippingInfo")
public class ShippingInfo extends AbstractEntity{

    @Column(name="shippingType")
    @NotNull
    @NotEmpty
    private String shippingType;
    @Column(name="shippingCost")
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
