package com.caliber.exception;

import com.caliber.modal.ErrorDetails;

import java.util.List;

public class ValidationException extends RuntimeException {

    final List<ErrorDetails> errorDetailsList;
    public ValidationException(String message , final List<ErrorDetails> errorDetailsList) {
        super(message);
        this.errorDetailsList = errorDetailsList;
    }

    public List<ErrorDetails> getErrorDetailsList(){
        return errorDetailsList;
    }

    public ValidationException(String message, List<ErrorDetails> errorDetailsList , Throwable cause) {
        super(message, cause);
        this.errorDetailsList = errorDetailsList;
    }
}
