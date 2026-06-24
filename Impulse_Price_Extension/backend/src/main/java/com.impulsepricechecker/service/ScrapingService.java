package com.impulsepricechecker.service;

import com.impulsepricechecker.model.PriceResult;
import com.impulsepricechecker.model.Product;
import com.impulsepricechecker.service.scraper.Scraper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScrapingService {
/*
With a list of scrapers available, go through each scraper to get different prices for each product
 */
    private List<Scraper> scrapers;
    public ScrapingService(List<Scraper> scrapers){
        this.scrapers = scrapers;
    }
    public List<PriceResult> scrapeAllSites(Product product){
        return scrapers.parallelStream()
                .flatMap(scraper -> {
                    try{
                        return scraper.search(product.getTitle()).stream();
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                        return List.<PriceResult>of().stream();
                    }
                })
                .sorted(Comparator.comparingDouble(PriceResult::getPrice)).toList();
    }

}
