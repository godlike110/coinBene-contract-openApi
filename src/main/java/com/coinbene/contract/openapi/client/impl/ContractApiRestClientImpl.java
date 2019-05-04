package com.coinbene.contract.openapi.client.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.coinbene.contract.openapi.client.constant.CoinBeneConstants;
import com.coinbene.contract.openapi.client.enums.Direction;
import com.coinbene.contract.openapi.client.enums.OrderType;
import com.coinbene.contract.openapi.client.model.*;
import com.coinbene.contract.openapi.client.service.CoinBeneOpenApiService;
import com.coinbene.contract.openapi.client.ApiRestClient;
import com.coinbene.contract.openapi.client.utils.ObjectUtils;
import com.coinbene.contract.openapi.client.utils.SignUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;
import java.util.Map;

import static com.coinbene.contract.openapi.client.impl.CoinBeneApiServiceGenerator.executeSync;

/**
 * Implementation of coinbene contract's REST API using Retrofit with synchronous/blocking method calls.
 */
public class ContractApiRestClientImpl implements ApiRestClient {

    private static Logger logger = LoggerFactory.getLogger(ContractApiRestClientImpl.class);

    private final CoinBeneOpenApiService apiService;

    public ContractApiRestClientImpl(String apiKey, String secret) {
        apiService = CoinBeneApiServiceGenerator.createService(CoinBeneOpenApiService.class, apiKey, secret);
    }


    @Override
    public void ping() {
        CoinBeneApiServiceGenerator.executeSync(apiService.ping());
    }

    @Override
    public Map<String,Ticker> getTickers() {
        Response result = executeSync(apiService.getTickers());
        Map<String,Object> tickerMap = (Map<String, Object>) result.getData();

        Map<String,Ticker> tickers = Maps.newHashMap();

        for(String key:tickerMap.keySet()) {
            tickers.put(key, (Ticker) ObjectUtils.mapToObject((Map) tickerMap.get(key),Ticker.class));
        }

        return tickers;
    }

    @Override
    public Map<String,List<MarketOrder>> getOrderBook(String symble, int size) {
        Response result = executeSync(apiService.getOrderBook(symble,10));
        JSONObject robj = JSON.parseObject(JSON.toJSONString(result.getData())).getJSONObject("orderbook");

        Map<String,List<MarketOrder>> orderLists  = Maps.newHashMap();

        JSONArray bidArray = robj.getJSONArray("bids");

        List<MarketOrder> bidsOrders = Lists.newArrayList();
        for(Object item:bidArray) {

            JSONArray array = (JSONArray) item;

            MarketOrder order = new MarketOrder();
            order.setPrice(array.getString(0));
            order.setNums(array.getLong(1));
            order.setOrders(array.getInteger(2));
            bidsOrders.add(order);

        }

        orderLists.put("bids",bidsOrders);

        JSONArray askArray = robj.getJSONArray("asks");

        List<MarketOrder> askOrders = Lists.newArrayList();
        for(Object item:askArray) {

            JSONArray array = (JSONArray) item;

            MarketOrder order = new MarketOrder();
            order.setPrice(array.getString(0));
            order.setNums(array.getLong(1));
            order.setOrders(array.getInteger(2));
            askOrders.add(order);

        }

        orderLists.put("asks",askOrders);

        return orderLists;
    }

    @Override
    public AccountInfo getAccountInfo() {
        JSONObject params = SignUtils.createRequestObject(Maps.newHashMap(),CoinBeneConstants.ACCOUNT_INFO_URL,System.currentTimeMillis(), CoinBeneConstants.API_ID,CoinBeneConstants.SECRET);
        Response result = executeSync(apiService.getAccountInfo(params));
        return (AccountInfo) ObjectUtils.mapToObject((Map) result.getData(),AccountInfo.class);
    }

    @Override
    public List<PositionInfo> getPositionList(String symbol) {
        Map<String,Object> paramMap = Maps.newHashMap();
        paramMap.put("symbol",symbol);
        JSONObject params = SignUtils.createRequestObject(paramMap,CoinBeneConstants.POSITION_INFO_URL,System.currentTimeMillis(), CoinBeneConstants.API_ID,CoinBeneConstants.SECRET);
        Response result = executeSync(apiService.getPositionList(params));

        List<List> positionArray = (List<List>) result.getData();

        List<PositionInfo> positionInfos = Lists.newArrayList();

        for(List item:positionArray) {

            PositionInfo info = new PositionInfo();
            info.setAvailableQuantity((Integer) item.get(0));
            info.setAverageCost((String) item.get(1));
            info.setDeleveragePercentile((Integer) item.get(3));
            info.setLeverage((Integer) item.get(4));
            info.setLiquidationPrice((String) item.get(5));
            info.setMarkPrice((String) item.get(6));
            info.setPositionMargin((String) item.get(7));
            info.setPositionValue((String) item.get(8));
            info.setQuantity((Integer) item.get(9));
            info.setRealisedPnl((String) item.get(10));
            info.setROE((String) item.get(11));
            info.setSide((String) item.get(12));
            info.setSymbol((String) item.get(13));
            info.setUnrealisedPnl((String) item.get(14));
            positionInfos.add(info);

        }

        return positionInfos;
    }

    @Override
    public String placeOrder(String symbol, OrderType orderType, int leveage, String price, int quatity, Direction direction, String requestNo) {

        try {

            Map<String, Object> paramMap = Maps.newHashMap();
            paramMap.put("symbol", symbol);
            paramMap.put("orderType", orderType.getType());
            paramMap.put("leverage", leveage);
            if (StringUtils.isNotBlank(price)) {
                paramMap.put("orderPrice", price);
            }
            paramMap.put("quantity", quatity);
            paramMap.put("direction", direction.getDirection());
            paramMap.put("requestId", requestNo);

            JSONObject params = SignUtils.createRequestObject(paramMap, CoinBeneConstants.PLACE_ORDER_URL, System.currentTimeMillis(), CoinBeneConstants.API_ID, CoinBeneConstants.SECRET);
            JSONObject result = executeSync(apiService.placeOrder(params));
            return result.getJSONObject("data").getString("orderId");
        } catch (Exception e) {
            logger.error("placeOrder ",e);
        }

        return "";

    }

    @Override
    public String cancelOrder(String orderId) {

        try {

            Map<String, Object> paramMap = Maps.newHashMap();
            paramMap.put("orderId", orderId);
            JSONObject params = SignUtils.createRequestObject(paramMap, CoinBeneConstants.CANCEL_ORDER, System.currentTimeMillis(), CoinBeneConstants.API_ID, CoinBeneConstants.SECRET);
            JSONObject result = executeSync(apiService.cancelOrder(params));

            return result.getInteger("code") == 0 ? "true" : "false";
        } catch (Exception e) {

            logger.error("cancelOrder error",e);

        }

        return "false";
    }

    @Override
    public String startUserDataStream(Long recvWindow, Long timestamp) {
        return null;
    }

    @Override
    public void keepAliveUserDataStream(String listenKey, Long recvWindow, Long timestamp) {

    }

    @Override
    public void closeUserDataStream(String listenKey, Long recvWindow, Long timestamp) {

    }


}
