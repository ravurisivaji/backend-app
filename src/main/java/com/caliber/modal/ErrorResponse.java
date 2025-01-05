package com.caliber.modal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse extends Response {

    private String rootErrorMsg;

    private List<ErrorDetails> errorDetailsList;

    private ErrorCode errorCode;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date timeStamp;

    public ErrorResponse() {}
    public ErrorResponse(final String message, final  ErrorCode errorCode, HttpStatus status, String rootErrorMsg, List<ErrorDetails> errorDetailsList) {
        super(message, status, null);
        this.rootErrorMsg = rootErrorMsg;
        this.errorDetailsList = errorDetailsList;
        this.errorCode = errorCode;
        this.timeStamp = new Date();

    }



    public static ErrorResponse of(final String message, final  ErrorCode errorCode, HttpStatus status, String rootErrorMsg, List<ErrorDetails> errorDetailsList) {
        return new ErrorResponse(message, errorCode, status, rootErrorMsg, errorDetailsList);
    }

}
