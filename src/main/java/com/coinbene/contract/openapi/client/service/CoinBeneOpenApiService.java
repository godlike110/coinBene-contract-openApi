package com.coinbene.contract.openapi.client.service;


import com.alibaba.fastjson.JSONObject;
import com.coinbene.contract.openapi.client.constant.CoinBeneConstants;
import com.coinbene.contract.openapi.client.model.Response;
import com.coinbene.contract.openapi.client.model.Ticker;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 * coinbene's REST API URL mappings and endpoint security configuration.
 */
public interface CoinBeneOpenApiService {

    // General endpoints
    @GET("/openapi/quote/v1/ping")
    @Headers("test")
    Call<Void> ping();

    @GET(CoinBeneConstants.TICKER_URL)
    Call<Response> getTickers();

    @GET(CoinBeneConstants.ORDER_BOOK_URL)
    Call<Response> getOrderBook(@Query("symbol") String symbol,@Query("size") int size);


    @POST(CoinBeneConstants.ACCOUNT_INFO_URL)
    Call<Response> getAccountInfo(@Body JSONObject body);


    @POST(CoinBeneConstants.POSITION_INFO_URL)
    Call<Response> getPositionList(@Body JSONObject body);

    @POST(CoinBeneConstants.PLACE_ORDER_URL)
    Call<JSONObject> placeOrder(@Body JSONObject body);

    @POST(CoinBeneConstants.CANCEL_ORDER)
    Call<JSONObject> cancelOrder(@Body JSONObject body);

}
