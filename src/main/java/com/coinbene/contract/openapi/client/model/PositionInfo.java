package com.coinbene.contract.openapi.client.model;

/**
 * @author wenzhiwei
 * @time 2019-05-04 13:26
 **/
public class PositionInfo {

    //可平仓数量
    private int availableQuantity;
    //开仓均价
    private String averageCost;
    //减仓队列
    private int deleveragePercentile;

    //杠杆倍数
    private int leverage;

    //强平价格
    private String liquidationPrice;

    //标记价格
    private String markPrice;

    //仓位保证金
    private String positionMargin;

    //仓位价值
    private String positionValue;

    //持仓数量
    private int quantity;

    //已实现盈亏
    private String realisedPnl;

    //未实现盈亏
    private String ROE;

    //方向
    private String side;

    //合约名称
    private String symbol;

    private String unrealisedPnl;

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public String getAverageCost() {
        return averageCost;
    }

    public void setAverageCost(String averageCost) {
        this.averageCost = averageCost;
    }

    public int getDeleveragePercentile() {
        return deleveragePercentile;
    }

    public void setDeleveragePercentile(int deleveragePercentile) {
        this.deleveragePercentile = deleveragePercentile;
    }

    public int getLeverage() {
        return leverage;
    }

    public void setLeverage(int leverage) {
        this.leverage = leverage;
    }

    public String getLiquidationPrice() {
        return liquidationPrice;
    }

    public void setLiquidationPrice(String liquidationPrice) {
        this.liquidationPrice = liquidationPrice;
    }

    public String getMarkPrice() {
        return markPrice;
    }

    public void setMarkPrice(String markPrice) {
        this.markPrice = markPrice;
    }

    public String getPositionMargin() {
        return positionMargin;
    }

    public void setPositionMargin(String positionMargin) {
        this.positionMargin = positionMargin;
    }

    public String getPositionValue() {
        return positionValue;
    }

    public void setPositionValue(String positionValue) {
        this.positionValue = positionValue;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getRealisedPnl() {
        return realisedPnl;
    }

    public void setRealisedPnl(String realisedPnl) {
        this.realisedPnl = realisedPnl;
    }

    public String getROE() {
        return ROE;
    }

    public void setROE(String ROE) {
        this.ROE = ROE;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getUnrealisedPnl() {
        return unrealisedPnl;
    }

    public void setUnrealisedPnl(String unrealisedPnl) {
        this.unrealisedPnl = unrealisedPnl;
    }
}
