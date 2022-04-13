package com.aston.ecommerce.asmar.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends AbstractEntity{

    @Column(name="delivery_status")
    @NotNull
    @NotEmpty
    private String deliveryStatus;
    @Column(name="order_date", nullable = false)
    private LocalDate orderDate;
    @Column(name="shipping_date")
    private LocalDate shippingDate;
    @Column(name="delivery_price", nullable = false)
    private float deliveryPrice;
    @Column(name="total", nullable = false)
    private float total;
    @OneToMany(mappedBy = "order")
    private List<CommandLine> commandLineList;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name ="address_id", nullable = false)
    private Address address;
    @ManyToOne
    @JoinColumn(name ="payment_id")
    private Payment payment;


    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }

    public float getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(float deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public List<CommandLine> getCommandLineList() {
        return commandLineList;
    }

    public void setCommandLineList(List<CommandLine> commandLineList) {
        this.commandLineList = commandLineList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
