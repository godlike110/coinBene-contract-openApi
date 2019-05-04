package com.coinbene.contract.openapi.client.model;

/**
 * 合约行情
 * @author wenzhiwei
 * @time 2019-05-01 17:03
 **/
public class Ticker {


    //合约交易对
    private String symbol;

    //最新价
    private String latestPrice;

    //买一价
    private String bestBidPrice;

    //卖一价
    private String bestAskPrice;

    //买一量
    private String bestBidSize;

    //卖一量
    private String bestAskSize;

    // 24小时最高价格
    private String high24h;

    // 24 小时最低价格
    private String low24h;

    // 标记价格
    private String markPrice;

    // 24小时成交量
    private String volume24h;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getLatestPrice() {
        return latestPrice;
    }

    public void setLatestPrice(String latestPrice) {
        this.latestPrice = latestPrice;
    }

    public String getBestBidPrice() {
        return bestBidPrice;
    }

    public void setBestBidPrice(String bestBidPrice) {
        this.bestBidPrice = bestBidPrice;
    }

    public String getBestAskPrice() {
        return bestAskPrice;
    }

    public void setBestAskPrice(String bestAskPrice) {
        this.bestAskPrice = bestAskPrice;
    }

    public String getBestBidSize() {
        return bestBidSize;
    }

    public void setBestBidSize(String bestBidSize) {
        this.bestBidSize = bestBidSize;
    }

    public String getBestAskSize() {
        return bestAskSize;
    }

    public void setBestAskSize(String bestAskSize) {
        this.bestAskSize = bestAskSize;
    }

    public String getHigh24h() {
        return high24h;
    }

    public void setHigh24h(String high24h) {
        this.high24h = high24h;
    }

    public String getLow24h() {
        return low24h;
    }

    public void setLow24h(String low24h) {
        this.low24h = low24h;
    }

    public String getMarkPrice() {
        return markPrice;
    }

    public void setMarkPrice(String markPrice) {
        this.markPrice = markPrice;
    }

    public String getVolume24h() {
        return volume24h;
    }

    public void setVolume24h(String volume24h) {
        this.volume24h = volume24h;
    }
}
