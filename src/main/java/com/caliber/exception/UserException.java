package com.caliber.exception;

public class UserException  extends RuntimeException implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    public UserException(String message ) {
        super(message);
    }
    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

}

