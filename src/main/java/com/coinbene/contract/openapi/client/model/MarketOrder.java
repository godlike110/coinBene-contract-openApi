package com.coinbene.contract.openapi.client.model;

/**
 * @author wenzhiwei
 * @time 2019-05-04 12:09
 **/
public class MarketOrder {

    private String price;
    private Long nums;
    private int orders;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Long getNums() {
        return nums;
    }

    public void setNums(Long nums) {
        this.nums = nums;
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }
}
