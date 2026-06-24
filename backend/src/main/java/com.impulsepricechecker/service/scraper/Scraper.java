package com.impulsepricechecker.service.scraper;

import com.impulsepricechecker.model.PriceResult;

import java.util.List;

//Interface for scraping logic from which the specific Scrapers would extend
public interface Scraper {
    List<PriceResult> search(String query);
    String getSiteName();
}
