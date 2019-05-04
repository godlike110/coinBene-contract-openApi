package com.coinbene.contract.openapi.test;

import com.alibaba.fastjson.JSON;
import com.coinbene.contract.openapi.client.ApiClientFactory;
import com.coinbene.contract.openapi.client.ApiRestClient;

import com.coinbene.contract.openapi.client.constant.CoinBeneConstants;
import com.coinbene.contract.openapi.client.enums.Direction;
import com.coinbene.contract.openapi.client.enums.OrderType;
import com.coinbene.contract.openapi.client.model.AccountInfo;
import com.coinbene.contract.openapi.client.model.MarketOrder;
import com.coinbene.contract.openapi.client.model.PositionInfo;
import com.coinbene.contract.openapi.client.model.Ticker;

import java.util.List;
import java.util.Map;

public class AccountRestApiTest {


    public static void main(String[] args) throws InterruptedException {

        ApiClientFactory factory = ApiClientFactory.newInstance(CoinBeneConstants.API_ID, CoinBeneConstants.SECRET);
        ApiRestClient client = factory.newRestClient();

        //获取盘口价格信息
        Map<String,Ticker> tickers = client.getTickers();
        System.out.println("tickers");

        //获取盘口挂单
        Map<String,List<MarketOrder>> orderBooks = client.getOrderBook("ETHUSDT",10);
//        System.out.println("orderBooks");

        AccountInfo accountInfo = client.getAccountInfo();
        System.out.println("accountInfo" + JSON.toJSONString(accountInfo));

        //获取仓位列表
        List<PositionInfo> positionInfos = client.getPositionList("BTCUSDT");
        System.out.println("positionLists" + JSON.toJSONString(positionInfos));

        //下单
        String orderid = client.placeOrder("BTCUSDT", OrderType.LIMIT,100,"5799",1900000, Direction.CLOSELONG,String.valueOf(System.currentTimeMillis()));
        System.out.println("place order");


        //撤单
        String result = client.cancelOrder(orderid);
        System.out.println("cancelorder");


    }

}
