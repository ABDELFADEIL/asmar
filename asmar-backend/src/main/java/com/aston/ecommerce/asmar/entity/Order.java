package com.aston.ecommerce.asmar.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order extends AbstractEntity{


    @Column(name="delivery_statut")
    @NotNull
    @NotEmpty
    private String deliveryStatut;

    @Column(name="order_date")
    @NotNull
    @NotEmpty
    private Date orderDate;

    @Column(name="shipping_date")
    @NotNull
    @NotEmpty
    private Date shippingDate;

    @Column(name="delivery_price")
    @NotNull
    @NotEmpty
    private Long deliveryPrice;

    @Column(name="total")
    @NotNull
    @NotEmpty
    private String total;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id", nullable = true)
    private Payment payment;

    public Order(String deliveryStatut, Date orderDate, Date shippingDate, Long deliveryPrice, String total) {
        this.deliveryStatut = deliveryStatut;
        this.orderDate = orderDate;
        this.shippingDate = shippingDate;
        this.deliveryPrice = deliveryPrice;
        this.total = total;
    }


    public String getDeliveryStatut() {
        return deliveryStatut;
    }

    public void setDeliveryStatut(String deliveryStatut) {
        this.deliveryStatut = deliveryStatut;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public Long getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(Long deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

}
