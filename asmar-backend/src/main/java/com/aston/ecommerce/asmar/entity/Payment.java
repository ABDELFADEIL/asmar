package com.aston.ecommerce.asmar.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

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
    private Date paymentDate;

    @Column(name="total")
    @NotNull
    @NotEmpty
    private String total;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;


    public Payment(String type, Date paymentDate, String total) {
        this.type = type;
        this.paymentDate = paymentDate;
        this.total = total;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
