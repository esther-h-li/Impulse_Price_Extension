package com.impulsepricechecker.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class VerificationController {

    @GetMapping("/")
    public String home() {
        return "Working";
    }

}
