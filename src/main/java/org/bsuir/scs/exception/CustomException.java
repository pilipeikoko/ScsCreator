package org.bsuir.scs.exception;

public class CustomException extends Exception{
    public CustomException() {
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
