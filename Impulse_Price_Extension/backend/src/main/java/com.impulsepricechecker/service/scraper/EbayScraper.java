package com.impulsepricechecker.service.scraper;

import com.impulsepricechecker.model.PriceResult;
import com.impulsepricechecker.service.EbayRefreshService;
import org.springframework.stereotype.Service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service

public class EbayScraper implements Scraper {
    private ScraperConfig config;
    private final OkHttpClient httpClient = new OkHttpClient();
    private final EbayRefreshService tokenRefreshService;

    public EbayScraper(EbayRefreshService tokenRefreshService){
        System.out.println("EbayScraper bean created");
        this.tokenRefreshService = tokenRefreshService;
    }
    @Override
    public List<PriceResult> search(String name) {
        return apiSearch(name);
    }
    public String getSiteName() {
        return "eBay";
    }

    public void setConfig(ScraperConfig config){
        this.config = config;
    }

    private List<PriceResult> apiSearch(String name) {
        List<PriceResult> results = new ArrayList<>();
        System.out.println("Searching...");
        try{
            String url = config.getApiBaseUrl() + "/item_summary/search?q=" + URLEncoder.encode(name, StandardCharsets.UTF_8) +  "&limit=10&sort=price";
            String token = tokenRefreshService.getValidToken();
            if (token == null) {
                System.err.println("Failed to get valid token");

                return results;
            }

            Request request = new Request.Builder()
                    .url(url)
                    .header("Authorization", "Bearer " + token)
                    .header("X-EBAY-C-ENDUSERCTX", "affiliateCampaignId=5339137464")
                    .build();
            Response response = httpClient.newCall(request).execute();
            System.out.println("Response code: " + response.code());
            System.out.println("Response message: " + response.message());
            if (!response.isSuccessful()) {
                System.err.println("Response not successful");
                return results;
            }

            JSONObject json = new JSONObject(response.body().string());
            JSONArray items = json.optJSONArray("itemSummaries");
            if(items == null) {
                System.err.println("Item is null");
                return results;
            }

            for (int i = 0; i < items.length(); i++) {
                JSONObject item = items.getJSONObject(i);
                System.out.println("Adding item " + Integer.toString(i));
                String link = item.optString("itemAffiliateWebUrl", item.getString("itemWebUrl"));
                results.add(new PriceResult(
                                item.getString("title"),
                                item.getJSONObject("price").getDouble("value"),
                                link,
                                item.getJSONObject("image").getString("imageUrl")
                        )
                );
            }
        } catch (Exception e){
            System.err.println("Error");
            e.printStackTrace();
        }
        System.out.println("Results found");
        return results;

    }

}




