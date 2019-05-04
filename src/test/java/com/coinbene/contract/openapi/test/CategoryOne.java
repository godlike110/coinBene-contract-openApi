package com.coinbene.contract.openapi.test;

import com.coinbene.contract.openapi.client.ApiClientFactory;
import com.coinbene.contract.openapi.client.ApiRestClient;
import com.coinbene.contract.openapi.client.constant.CoinBeneConstants;
import com.coinbene.contract.openapi.client.enums.Direction;
import com.coinbene.contract.openapi.client.enums.OrderType;
import com.coinbene.contract.openapi.client.model.AccountInfo;
import com.coinbene.contract.openapi.client.model.MarketOrder;
import com.coinbene.contract.openapi.client.model.Ticker;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wenzhiwei
 * @time 2019-05-04 14:41
 **/
public class CategoryOne {

    public static void main(String[] args) throws InterruptedException {

        ApiClientFactory factory = ApiClientFactory.newInstance(CoinBeneConstants.API_ID, CoinBeneConstants.SECRET);
        ApiRestClient client = factory.newRestClient();

        while (true) {

            Thread.sleep(20);
            Map<String, List<MarketOrder>> markets = client.getOrderBook("ETHUSDT", 10);

            //AccountInfo accountInfo = client.getAccountInfo();

            //   Map<String, Ticker> tickerMap = client.getTickers();


            String ethPlaceAskOrderId = "";
            String ethPlaceBidOrderId = "";
            if(new BigDecimal(markets.get("asks").get(0).getPrice()).subtract(new BigDecimal(markets.get("bids").get(0).getPrice())).toPlainString().equalsIgnoreCase("0.05")) {
                Thread.sleep(100);
            } {

                ethPlaceAskOrderId = client.placeOrder("ETHUSDT", OrderType.LIMIT, 100, new BigDecimal(markets.get("asks").get(0).getPrice()).subtract(new BigDecimal("0.05")).toPlainString(), 111111, Direction.OPENSHORT, String.valueOf(System.currentTimeMillis()));

                ethPlaceBidOrderId = client.placeOrder("ETHUSDT", OrderType.LIMIT, 100, new BigDecimal(markets.get("bids").get(0).getPrice()).add(new BigDecimal("0.05")).toPlainString(), 111111, Direction.OPENLON, String.valueOf(System.currentTimeMillis()));


            }


            Map<String, List<MarketOrder>> btcMarket = client.getOrderBook("BTCUSDT", 10);

            //AccountInfo accountInfo = client.getAccountInfo();

            //   Map<String, Ticker> tickerMap = client.getTickers();

            String btcPlaceAskOrderId = "";
            String btcPlaceBidOrderId = "";

            if(new BigDecimal(btcMarket.get("asks").get(0).getPrice()).subtract(new BigDecimal(btcMarket.get("bids").get(0).getPrice())).toPlainString().equalsIgnoreCase("0.5")) {
                Thread.sleep(100);
            } else {

                btcPlaceAskOrderId = client.placeOrder("BTCUSDT", OrderType.LIMIT, 100, new BigDecimal(btcMarket.get("asks").get(0).getPrice()).subtract(new BigDecimal("0.5")).toPlainString(), 66666, Direction.OPENSHORT, String.valueOf(System.currentTimeMillis()));

                btcPlaceBidOrderId = client.placeOrder("BTCUSDT", OrderType.LIMIT, 100, new BigDecimal(btcMarket.get("bids").get(0).getPrice()).add(new BigDecimal("0.5")).toPlainString(), 66666, Direction.OPENLON, String.valueOf(System.currentTimeMillis()));

            }

            Thread.sleep(400);

            if(StringUtils.isNotBlank(ethPlaceAskOrderId)) {
                client.cancelOrder(ethPlaceAskOrderId);
            }

            if(StringUtils.isNotBlank(ethPlaceBidOrderId)) {

                client.cancelOrder(ethPlaceBidOrderId);
            }

            if(StringUtils.isNotBlank(btcPlaceAskOrderId)) {
                client.cancelOrder(btcPlaceAskOrderId);
            }

            if(StringUtils.isNotBlank(btcPlaceBidOrderId)) {
                client.cancelOrder(btcPlaceBidOrderId);
            }

        }

    }
}
