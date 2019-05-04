package com.coinbene.contract.openapi.client.exception;


import com.coinbene.contract.openapi.client.CoinBeneApiError;

/**
 * An exception which can occur while invoking methods of the BHex API.
 */
public class ApiException extends RuntimeException {

    private static final long serialVersionUID = 3788669840036201041L;
    /**
     * Error response object returned by BHex API.
     */
    private CoinBeneApiError error;

    /**
     * Instantiates a new BHex api exception.
     *
     * @param error an error response object
     */
    public ApiException(CoinBeneApiError error) {
        this.error = error;
    }

    /**
     * Instantiates a new BHex api exception.
     */
    public ApiException() {
        super();
    }

    /**
     * Instantiates a new BHex api exception.
     *
     * @param message the message
     */
    public ApiException(String message) {
        super(message);
    }

    /**
     * Instantiates a new BHex api exception.
     *
     * @param cause the cause
     */
    public ApiException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new BHex api exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @return the response error object from BHex API, or null if no response object was returned (e.g. server returned 500).
     */
    public CoinBeneApiError getError() {
        return error;
    }

    @Override
    public String getMessage() {
        if (error != null) {
            return error.getMsg();
        }
        return super.getMessage();
    }
}
