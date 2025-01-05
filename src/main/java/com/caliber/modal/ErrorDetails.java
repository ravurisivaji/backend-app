package com.caliber.modal;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDetails {

    Integer id;
    String colName;
    String value;
    String errMsg;

    public Integer getId() {
        return id;
    }

    public String getColName() {
        return colName;
    }

    public String getValue() {
        return value;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public ErrorDetails(Integer id, String colName, String value, String errMsg) {
        this.id = id;
        this.colName = colName;
        this.value = value;
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "ErrorDetails{" +
                "id=" + id +
                ", colName='" + colName + '\'' +
                ", value='" + value + '\'' +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}
