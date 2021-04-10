package org.bsuir.scs.exception;

public class customException extends Exception{
    public customException() {
    }

    public customException(String message) {
        super(message);
    }

    public customException(String message, Throwable cause) {
        super(message, cause);
    }
}
