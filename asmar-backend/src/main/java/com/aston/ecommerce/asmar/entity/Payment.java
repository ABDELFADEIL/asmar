package com.aston.ecommerce.asmar.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "payment")
public class Payment extends AbstractEntity{

    @Column(name="type")
    @NotNull
    @NotEmpty
    private String type;
    @Column(name="payment_date")
    @NotNull
    @NotEmpty
    private LocalDate paymentDate;
    @Column(name="total")
    @NotNull
    @NotEmpty
    private String total;

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
}
