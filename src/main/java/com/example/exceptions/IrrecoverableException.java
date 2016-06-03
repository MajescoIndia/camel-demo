package com.example.exceptions;

/**
 * @author Biplab Nayak [Created on 6/3/2016].
 */
public class IrrecoverableException extends Exception {

    public IrrecoverableException() {
        super();
    }

    public IrrecoverableException(String message) {
        super(message);
    }

    public IrrecoverableException(Throwable cause) {
        super(cause);
    }

    public IrrecoverableException(String message, Throwable cause) {
        super(message, cause);
    }

}
