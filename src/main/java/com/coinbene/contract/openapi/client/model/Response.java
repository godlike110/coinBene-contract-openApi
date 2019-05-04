package com.coinbene.contract.openapi.client.model;

import com.fasterxml.jackson.databind.util.JSONPObject;

/**
 * @author wenzhiwei
 * @time 2019-05-01 19:08
 **/
public class Response<T> {

    private int code;
    private String message;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
