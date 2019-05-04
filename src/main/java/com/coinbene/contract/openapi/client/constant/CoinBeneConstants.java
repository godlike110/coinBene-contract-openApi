package com.coinbene.contract.openapi.client.constant;


import com.sun.tools.doclets.formats.html.PackageUseWriter;

public class CoinBeneConstants {

    public static final long DEFAULT_RECEIVING_WINDOW = 5_000L;

    public static final String API_ID = "xxx";

    public static final String SECRET = "xxx";


    public static final String API_BASE_URL = "http://openapi-contract.coinbene.com";

    public static final String PONG_MSG_KEY = "pong";

    public static final String PING_MSG_KEY = "ping";

    /**
     * Streaming API base URL.
     */
    public static final String WS_API_BASE_URL = "wss://openapi-contract.coinbene.com/openapi/quote/ws/v1";


    public static final String SING_HEADER_HEADER_KEY = "SIGN";
    public static final String SING_HEADER_HEADER = SING_HEADER_HEADER_KEY+":#";

    /**
     * 心跳间隔 1分钟一次
     */
    public static final long HEART_BEAT_INTERVAL = 60 * 1000;


    public static final String ACCOUNT_INFO_URL = "/api/swap/v1/account/info";

    public static final String TICKER_URL = "api/swap/v1/market/tickers";

    public static final String ORDER_BOOK_URL = "/api/swap/v1/market/orderbook";

    public static final String POSITION_INFO_URL = "/api/swap/v1/position/all";

    public static final String PLACE_ORDER_URL = "/api/swap/v1/trade/order/place";

    public static final String CANCEL_ORDER = "/api/swap/v1/trade/order/cancel";



}
