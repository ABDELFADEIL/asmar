package com.aston.ecommerce.asmar.exption;

public class PaymentExpception extends RuntimeException {

    public PaymentExpception() {
    }

    public PaymentExpception(String message) {
        super(message);
    }

    public PaymentExpception(String message, Throwable cause) {
        super(message, cause);
    }

    public PaymentExpception(Throwable cause) {
        super(cause);
    }
}
