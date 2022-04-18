package com.aston.ecommerce.asmar.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "payment")
public class Payment extends AbstractEntity{

    @Column(name="type")
    @NotNull
    @NotEmpty
    private String type;
    @Column(name="payment_id")
    private String paymentId;
    @Column(name="payment_date", nullable = false)
    private LocalDate paymentDate;
    @Column(name="total", nullable = false)
    private String total;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address billingAddress;

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }


    @Override
    public String toString() {
        return "Payment{" +
                "type='" + type + '\'' +
                ", paymentId='" + paymentId + '\'' +
                ", paymentDate=" + paymentDate +
                ", total='" + total + '\'' +
                ", billingAddress=" + billingAddress +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;
        Payment payment = (Payment) o;
        return getType().equals(payment.getType()) &&
                paymentId.equals(payment.paymentId) &&
                getPaymentDate().equals(payment.getPaymentDate()) &&
                getTotal().equals(payment.getTotal()) &&
                getBillingAddress().equals(payment.getBillingAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), paymentId, getPaymentDate(), getTotal(), getBillingAddress());
    }
}
