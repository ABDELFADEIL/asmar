package com.aston.ecommerce.asmar.dto;

import com.aston.ecommerce.asmar.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


public class PaymentDTO {


    private String type;
    private LocalDate paymentDate;
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

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "type='" + type + '\'' +
                ", paymentDate=" + paymentDate +
                ", total='" + total + '\'' +
                '}';
    }
}
