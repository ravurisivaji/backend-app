package com.caliber.modal;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorCode {

    GLOBAL("GLOBAL"),
    USER_ERR("USER_ERR"),
    SERV_ERR("SERV_ERR"),
    AUTH_ERR("AUTH_ERR"),
    DUP_DATA_ERR("DUP_DATA_ERR"),
    DATA_ERR("DATA_ERR"),
    AUTH_TOKEN_EXPIRED("AUTH_TOKEN_EXPIRED"),
    AUTH_INV_CARDS("AUTH_INV_CARDS"),
    AUTH_ROLE_ERR("AUTH_ROLE_ERR"),
    VALIDATION_ERR("VALIDATION_ERR")
    ;

    private String errCode;

    private ErrorCode(String errCode) {
        this.errCode = errCode;
    }

    @JsonValue
    public String getErrCode() {
        return errCode;
    }
}
