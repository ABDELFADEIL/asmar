package com.aston.ecommerce.asmar.exption;

public class CommandLineExpception extends RuntimeException {

    public CommandLineExpception() {
    }

    public CommandLineExpception(String message) {
        super(message);
    }

    public CommandLineExpception(String message, Throwable cause) {
        super(message, cause);
    }

    public CommandLineExpception(Throwable cause) {
        super(cause);
    }
}
