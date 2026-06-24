package com.impulsepricechecker.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

@RestController
@RequestMapping("/ebay/notifications") //sets up REST endpoint here
public class EbayNotifController {
    private final String verificationToken;
    private final String endpoint;

    public EbayNotifController(
            @Value("${ebay.webhook.verification-token}") String verificationToken,
            @Value("${ebay.webhook.endpoint-url}") String endpoint) {
        this.verificationToken = verificationToken;
        this.endpoint = endpoint;
    }


    static class VerificationResponse{
        @JsonProperty("challengeResponse")
        public final String challengeResponse;
        public VerificationResponse(String challengeCode){
            this.challengeResponse = challengeCode;
        }
    }
    @GetMapping()
    public ResponseEntity<VerificationResponse> verify(
        @RequestParam("challenge_code") String challengeCode){
        try{

            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            digest.update(challengeCode.getBytes(StandardCharsets.UTF_8));
            digest.update(verificationToken.getBytes(StandardCharsets.UTF_8));
            byte[]hashBytes = digest.digest(endpoint.getBytes(StandardCharsets.UTF_8));

            String hashedValue = HexFormat.of().formatHex(hashBytes);

            return ResponseEntity.ok(new VerificationResponse(hashedValue));
        } catch (NoSuchAlgorithmException e){
            return ResponseEntity.internalServerError().build();
        }

    }

    @PostMapping
    public ResponseEntity<Void> handleNotification(@RequestBody String notification){
        try{
            System.out.println("Received eBay notifiation: " + notification);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
