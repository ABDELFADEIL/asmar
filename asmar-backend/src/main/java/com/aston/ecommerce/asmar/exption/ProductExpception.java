package com.aston.ecommerce.asmar.exption;

public class ProductExpception extends RuntimeException {

    public ProductExpception() {
    }

    public ProductExpception(String message) {
        super(message);
    }

    public ProductExpception(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductExpception(Throwable cause) {
        super(cause);
    }
}
