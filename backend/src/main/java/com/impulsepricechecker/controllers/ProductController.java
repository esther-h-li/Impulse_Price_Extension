package com.impulsepricechecker.controllers;

import com.impulsepricechecker.model.PriceResult;
import com.impulsepricechecker.model.Product;
import com.impulsepricechecker.service.ScrapingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")

public class ProductController {
    private final ScrapingService scrapingService;
    public ProductController(ScrapingService scrapingService) {
        this.scrapingService = scrapingService;
    }

    @PostMapping
    public List<PriceResult> getProduct(@RequestBody Product product) {
        System.out.println("===== ENDPOINT HIT =====");

        System.out.println("Product: " + product.getTitle());


        return scrapingService.scrapeAllSites(product);
    }
}
