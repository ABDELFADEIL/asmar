package com.aston.ecommerce.asmar.exption;

public class OrderExpception extends RuntimeException {

    public OrderExpception() {
    }

    public OrderExpception(String message) {
        super(message);
    }

    public OrderExpception(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderExpception(Throwable cause) {
        super(cause);
    }
}
