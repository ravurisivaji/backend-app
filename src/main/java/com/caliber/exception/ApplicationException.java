package com.caliber.exception;

import java.io.Serializable;

public class ApplicationException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;
    public ApplicationException(String message  ) {
        super(message);
    }
    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}
