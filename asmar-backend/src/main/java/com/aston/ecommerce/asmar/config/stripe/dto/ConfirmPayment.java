package com.aston.ecommerce.asmar.config.stripe.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ConfirmPayment {

    @NotNull
    private String paymentId;

    public ConfirmPayment(String paymentId) {
        this.paymentId = paymentId;
    }

    public ConfirmPayment() {
    }

    public String getPaymentId() {
        return paymentId;
    }
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }
}
