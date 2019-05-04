package com.coinbene.contract.openapi.client.model;

/**
 * @author wenzhiwei
 * @time 2019-05-04 09:35
 **/
public class AccountInfo {

    //可用余额
    private String availableBalance;
    //冻结余额
    private String frozenBalance;

    //当前资产
    private String marginBalance;

    //保证金率
    private String marginRate;

    //账户余额
    private String totalBalance;


    //未实现盈亏
    private String unrealisedPnl;

    public String getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(String availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getFrozenBalance() {
        return frozenBalance;
    }

    public void setFrozenBalance(String frozenBalance) {
        this.frozenBalance = frozenBalance;
    }

    public String getMarginBalance() {
        return marginBalance;
    }

    public void setMarginBalance(String marginBalance) {
        this.marginBalance = marginBalance;
    }

    public String getMarginRate() {
        return marginRate;
    }

    public void setMarginRate(String marginRate) {
        this.marginRate = marginRate;
    }

    public String getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(String totalBalance) {
        this.totalBalance = totalBalance;
    }

    public String getUnrealisedPnl() {
        return unrealisedPnl;
    }

    public void setUnrealisedPnl(String unrealisedPnl) {
        this.unrealisedPnl = unrealisedPnl;
    }
}
