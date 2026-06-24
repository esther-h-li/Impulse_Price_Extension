package com.impulsepricechecker.service;

import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.Request;
import okhttp3.RequestBody;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import org.json.JSONObject;

import java.util.Base64;

@Service
public class EbayRefreshService {
    private final OkHttpClient httpClient = new OkHttpClient();

    @Value("${ebay.client-id}")
    private String clientId;

    @Value("${ebay.client-secret}")
    private String clientSecret;

    private String currentToken;
    private long tokenExpiryTime;

    public String getValidToken(){
        if(currentToken != null && System.nanoTime() < tokenExpiryTime - 300_000_000_000L){
            return currentToken;
        }
        else return refreshToken();
    }

    public String refreshToken() {
        try{
            String url ="https://api.ebay.com/identity/v1/oauth2/token";
            String auth = clientId + ":" + clientSecret;
            String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
            RequestBody body = RequestBody.create(
                    "grant_type=client_credentials&scope=https://api.ebay.com/oauth/api_scope",
                    okhttp3.MediaType.parse("application/x-www-form-urlencoded")
            );
            Request request = new Request.Builder()
                    .url(url)
                    .header("Authorization", "Basic " + encodedAuth)
                    .post(body)
                    .build();
            Response response = httpClient.newCall(request).execute();

            if(!response.isSuccessful()) {
                System.err.println("Token refresh failed: " + response.code());
                return null;
            }

            JSONObject json = new JSONObject(response.body().string());
            currentToken = json.getString("access_token");
            long expiresIn = json.getLong("expires_in");
            tokenExpiryTime= System.nanoTime() + (expiresIn * 1_000_000_000L);

            System.out.println("eBay token refreshed. Expires in " + (expiresIn * 1_000_000_000L));
            return currentToken;
        } catch (Exception e) {
            System.err.println("Error refreshing eBay token: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    public void updateApplicationToken(String newToken) {
        this.currentToken = newToken;
        System.out.println("Token updated in service");
    }

}
