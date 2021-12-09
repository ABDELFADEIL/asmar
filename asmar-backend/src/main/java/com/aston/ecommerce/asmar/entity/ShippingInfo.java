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
}
