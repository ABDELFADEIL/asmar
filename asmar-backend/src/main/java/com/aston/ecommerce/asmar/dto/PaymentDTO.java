package com.aston.ecommerce.asmar.dto;

import java.time.LocalDate;


public class PaymentDTO {

    private Integer id;
    private String type;
    private LocalDate paymentDate;
    private String total;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return "PaymentDTO{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", paymentDate=" + paymentDate +
                ", total='" + total + '\'' +
                '}';
    }
}
