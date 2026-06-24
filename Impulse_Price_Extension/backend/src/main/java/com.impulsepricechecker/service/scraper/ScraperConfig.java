package com.impulsepricechecker.service.scraper;

public class ScraperConfig {

    private String authToken;
    private String apiBaseUrl;
    public ScraperConfig( String authToken, String apiBaseUrl) {

        this.authToken = authToken;
        this.apiBaseUrl = apiBaseUrl;
    }


    public String getAuthToken() {
        return authToken;
    }

    public String getApiBaseUrl() {
        return apiBaseUrl;
    }
}
