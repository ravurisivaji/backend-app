package com.caliber.modal;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class Response {

    private HttpStatus status;
    private String message;
    private Object respObj;
    private Date timestamp;

    public Response(String message,HttpStatus status,  Object respObj) {
        this.status = status;
        this.message = message;
        this.respObj = respObj;
    }

    public Response() {
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getRespObj() {
        return respObj;
    }

    public void setRespObj(Object respObj) {
        this.respObj = respObj;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Response{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", respObj=" + respObj +
                ", timestamp=" + timestamp +
                '}';
    }
}
