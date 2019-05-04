package com.coinbene.contract.openapi.client;


import com.coinbene.contract.openapi.client.impl.ContractApiRestClientImpl;

/**
 * A factory for creating api client objects.
 */
public class ApiClientFactory {

    /**
     * API Key
     */
    private String apiKey;

    /**
     * Secret.
     */
    private String secret;

    /**
     * Instantiates a new api client factory.
     *
     * @param apiKey the API key
     * @param secret the Secret
     */
    private ApiClientFactory(String apiKey, String secret) {
        this.apiKey = apiKey;
        this.secret = secret;
    }

    /**
     * New instance.
     *
     * @param apiKey the API key
     * @param secret the Secret
     * @return the  api client factory
     */
    public static ApiClientFactory newInstance(String apiKey, String secret) {
        return new ApiClientFactory(apiKey, secret);
    }

    /**
     * New instance without authentication.
     *
     * @return the api client factory
     */
    public static ApiClientFactory newInstance() {
        return new ApiClientFactory(null, null);
    }

    /**
     * Creates a new synchronous/blocking REST client.
     */
    public ApiRestClient newRestClient() {
        return new ContractApiRestClientImpl(apiKey, secret);
    }




}
