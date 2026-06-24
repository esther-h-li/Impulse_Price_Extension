package com.impulsepricechecker.model;

import org.springframework.web.bind.annotation.RestController;

public class PriceResult {
    private String title;
    private double price;
    private String url;
    private String imageUrl;

    //setters for the site, price, url, and image url for a result product
    public PriceResult(String title, double price, String url, String imageUrl){
        this.title = title;
        this.price = price;
        this.url = url;
        this.imageUrl = imageUrl;
    }
//getters for the site, price, url, and image url for a result product
    public String getTitle(){
        return title;
    }

    public double getPrice(){
        return price;
    }

    public String getUrl(){
        return url;
    }

    public String getImageUrl(){
        return imageUrl;
    }
}
