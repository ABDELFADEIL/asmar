package com.aston.ecommerce.asmar.exption;

public class UserExpception extends RuntimeException {

    public UserExpception() {
    }

    public UserExpception(String message) {
        super(message);
    }

    public UserExpception(String message, Throwable cause) {
        super(message, cause);
    }

    public UserExpception(Throwable cause) {
        super(cause);
    }
}
