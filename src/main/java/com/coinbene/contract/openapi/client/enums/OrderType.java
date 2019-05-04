package com.coinbene.contract.openapi.client.enums;

/**
 * @author wenzhiwei
 * @time 2019-05-04 13:50
 **/
public enum OrderType {

    LIMIT("limit"),
    MARKET("market");

    private String type;

    OrderType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }}
