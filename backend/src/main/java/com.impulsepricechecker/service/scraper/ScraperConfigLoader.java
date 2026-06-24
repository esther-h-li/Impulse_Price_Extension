package com.impulsepricechecker.service.scraper;

import com.impulsepricechecker.service.EbayRefreshService;
import com.impulsepricechecker.service.scraper.EbayScraper;
import com.impulsepricechecker.service.scraper.ScraperConfig;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ScraperConfigLoader {
    @Autowired
    private EbayScraper ebayScraper;
    private final EbayRefreshService tokenRefreshService;

    @Value("${ebay.auth-token:null}")
    private String authToken;

    @Value("${ebay.api-base-url:null}")
    private String apiBaseUrl;

    public ScraperConfigLoader(EbayScraper ebayScraper, EbayRefreshService tokenRefreshService) {
        this.ebayScraper = ebayScraper;
        this.tokenRefreshService = tokenRefreshService;
    }



    @PostConstruct
    public void init(){
        ScraperConfig config = new ScraperConfig(authToken, apiBaseUrl);
        ebayScraper.setConfig(config);
        System.out.println("EbayScraper config loaded: " + apiBaseUrl);

        String token = tokenRefreshService.getValidToken();
        System.out.println("Token obtained");
    }


}