package com.coinbene.contract.openapi.client;


import com.coinbene.contract.openapi.client.enums.Direction;
import com.coinbene.contract.openapi.client.enums.OrderType;
import com.coinbene.contract.openapi.client.model.AccountInfo;
import com.coinbene.contract.openapi.client.model.MarketOrder;
import com.coinbene.contract.openapi.client.model.PositionInfo;
import com.coinbene.contract.openapi.client.model.Ticker;

import java.io.DataInput;
import java.util.List;
import java.util.Map;

public interface ApiRestClient {

    void ping();


    Map<String,Ticker> getTickers();

    Map<String,List<MarketOrder>> getOrderBook(String symble, int size);

    AccountInfo getAccountInfo();

    List<PositionInfo> getPositionList(String symbol);

    String placeOrder(String symbol, OrderType orderType, int leveage, String price, int quatity, Direction direction,String requestNo);

    String cancelOrder(String orderId);
    /**
     * Start a new user data stream.
     *
     * @return a listen key that can be used with data streams
     */
    String startUserDataStream(Long recvWindow, Long timestamp);

    /**
     * PING a user data stream to prevent a time out.
     *
     * @param listenKey listen key that identifies a data stream
     */
    void keepAliveUserDataStream(String listenKey, Long recvWindow, Long timestamp);

    /**
     * Close out a new user data stream.
     *
     * @param listenKey listen key that identifies a data stream
     */
    void closeUserDataStream(String listenKey, Long recvWindow, Long timestamp);

}
