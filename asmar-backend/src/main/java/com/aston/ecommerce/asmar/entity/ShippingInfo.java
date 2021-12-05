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
    private Long shippingCost;

    @Column(name="shipping_region")
    @NotNull
    @NotEmpty
    private int shippingRegion;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public ShippingInfo(String shippingType, Long shippingCost, int shippingRegion, Order order) {
        this.shippingType = shippingType;
        this.shippingCost = shippingCost;
        this.shippingRegion = shippingRegion;
        this.order = order;
    }

    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }

    public Long getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(Long shippingCost) {
        this.shippingCost = shippingCost;
    }

    public int getShippingRegion() {
        return shippingRegion;
    }

    public void setShippingRegion(int shippingRegion) {
        this.shippingRegion = shippingRegion;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
