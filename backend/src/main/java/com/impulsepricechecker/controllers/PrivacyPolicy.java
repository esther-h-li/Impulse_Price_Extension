package com.impulsepricechecker.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.MediaType;

@RestController
public class PrivacyPolicy {

    @GetMapping(value = "/privacypolicy", produces = MediaType.TEXT_HTML_VALUE)
    public String privacyPolicy() {
        return """
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Privacy Policy - Impulse Price Extension</title>
    <style>
        body {
            font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, sans-serif;
            line-height: 1.6;
            color: #333;
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f5f5f5;
        }
        .container {
            background: white;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        h1 {
            color: #2c3e50;
            border-bottom: 3px solid #3498db;
            padding-bottom: 10px;
        }
        h2 {
            color: #34495e;
            margin-top: 30px;
            margin-bottom: 15px;
        }
        h3 {
            color: #555;
            margin-top: 20px;
        }
        a {
            color: #3498db;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
        .meta {
            color: #7f8c8d;
            font-size: 0.9em;
            margin-bottom: 30px;
        }
        ul {
            padding-left: 20px;
        }
        li {
            margin-bottom: 8px;
        }
        .important {
            background: #fff3cd;
            border-left: 4px solid #ffc107;
            padding: 15px;
            margin: 20px 0;
        }
        .section {
            margin-bottom: 30px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Privacy Policy for Impulse Price Extension</h1>
        
        <div class="meta">
            <strong>Last Updated:</strong> January 15, 2026<br>
            <strong>Developer:</strong> Esther Li<br>
            <strong>Contact:</strong> <a href="mailto:estherhuanneli@gmail.com">estherhuanneli@gmail.com</a>
        </div>

        <div class="section">
            <h2>Overview</h2>
            <p>This Privacy Policy explains how the Impulse Price Extension ("the Extension") handles your information. Your privacy is important to us, and we are committed to transparency about our practices.</p>
        </div>

        <div class="section">
            <h2>What This Extension Does</h2>
            <p>The Extension analyzes eBay product listings you're viewing and helps you find similar items by providing alternative listings with comparison links.</p>
        </div>

        <div class="section">
            <h2>Data Collection</h2>
            
            <h3>What We Collect:</h3>
            <p>When you use the Extension on an eBay listing page, we automatically collect and transmit the following product information to our server:</p>
            <ul>
                <li>Product title</li>
                <li>Product price</li>
                <li>Product image URL</li>
            </ul>
            <p>This data is extracted from the publicly visible eBay listing page you're viewing.</p>

            <h3>What We Do NOT Collect:</h3>
            <ul>
                <li>Your personal information (name, email, address)</li>
                <li>Your eBay account information or login credentials</li>
                <li>Your browsing history beyond the current listing</li>
                <li>Your search queries outside of the Extension's use</li>
                <li>Your purchase history</li>
                <li>Payment information</li>
                <li>Cookies or unique identifiers that track you individually</li>
            </ul>

            <h3>How We Use This Data:</h3>
            <ul>
                <li>Product information is sent to our server to query eBay's Browse API for similar listings</li>
                <li>Our server uses the product title to search for comparable items</li>
                <li>Your server does not permanently store this data - it's processed in real-time and discarded immediately after generating results</li>
                <li>We query eBay's API on your behalf using our authentication credentials</li>
                <li>Results (similar products with comparison information) are returned to you through the Extension</li>
                <li>We do not build user profiles, track browsing patterns, or link searches to individual users</li>
            </ul>

            <div class="important">
                <strong>Automatic Data Collection:</strong> The Extension automatically collects product data when you visit an eBay product listing page. This happens in the background without requiring you to click a button. The data is sent to our server immediately upon collection.
            </div>

            <h3>Data Transmission:</h3>
            <ul>
                <li>Product data is transmitted securely via HTTPS to our server hosted on Google Cloud Platform</li>
                <li>Our server then transmits the product title to eBay's Browse API to find similar items</li>
                <li>Data is collected and sent automatically when you view eBay product listings</li>
                <li>eBay may process your search query according to their privacy policy</li>
            </ul>
        </div>

        <div class="section">
            <h2>Affiliate Links and Tracking</h2>
            
            <h3>How We Use Affiliate Links:</h3>
            <p>This Extension is monetized through the eBay Partner Network affiliate program. When you click on similar product links generated by this Extension, those links include our affiliate tracking code.</p>

            <h3>What eBay Tracks (Not Us):</h3>
            <p>When you click an affiliate link, eBay (not us) may track:</p>
            <ul>
                <li>That a click occurred from our affiliate ID</li>
                <li>Purchases made through those links</li>
                <li>Transaction details (item, price, date)</li>
            </ul>

            <h3>Important Notes:</h3>
            <ul>
                <li>We do not receive any personal information about you from eBay</li>
                <li>eBay's tracking is governed by <a href="https://www.ebay.com/help/policies/member-behaviour-policies/user-privacy-notice-privacy-policy" target="_blank">eBay's Privacy Policy</a></li>
                <li>You can review eBay's privacy practices on their website</li>
            </ul>
        </div>

        <div class="section">
            <h2>Data Storage and Retention</h2>
            
            <h3>On Our Servers:</h3>
            <ul>
                <li>Product information (title, price, image URL) is processed in real-time only</li>
                <li><strong>No product data is stored permanently</strong> - information is discarded immediately after processing</li>
                <li>We do not maintain databases of your searches, product views, or browsing activity</li>
                <li>Server request logs may be temporarily retained by Google Cloud Platform as part of standard infrastructure operations (see Third-Party Services section)</li>
            </ul>

            <h3>Local Storage:</h3>
            <ul>
                <li>The Extension does not store any data locally in your browser</li>
                <li>No preferences, settings, or browsing history are saved</li>
                <li>Removing the Extension removes all traces of it from your browser</li>
            </ul>
        </div>

        <div class="section">
            <h2>Permissions Used</h2>
            
            <h3>activeTab Permission:</h3>
            <ul>
                <li><strong>Why we need it:</strong> To read product information from the current eBay listing page you're viewing</li>
                <li><strong>What we access:</strong> Product title, price, and image URL visible on the page</li>
                <li><strong>Limitation:</strong> Only works on eBay product listing pages</li>
            </ul>
        </div>

        <div class="section">
            <h2>Third-Party Services</h2>
            
            <h3>Google Cloud Platform:</h3>
            <ul>
                <li>Our backend server is hosted on Google Cloud Platform (Cloud Run)</li>
                <li>Product information passes through Google's infrastructure</li>
                <li>Google may temporarily log requests as part of standard infrastructure operations (typically retained for 30 days)</li>
                <li>These logs may include request metadata but are not accessed or used by us for any purpose</li>
                <li>Google's data processing is governed by their <a href="https://cloud.google.com/terms/cloud-privacy-notice" target="_blank">Cloud Privacy Notice</a></li>
            </ul>

            <h3>eBay Browse API:</h3>
            <ul>
                <li>Our server uses eBay's Browse API to search for similar products</li>
                <li>Product titles are sent to eBay's servers for processing and search functionality</li>
                <li>eBay may collect and process this data according to their <a href="https://www.ebay.com/help/policies/member-behaviour-policies/user-privacy-notice-privacy-policy" target="_blank">Privacy Policy</a></li>
                <li>We include our affiliate campaign ID in API requests to eBay</li>
            </ul>

            <h3>eBay Partner Network:</h3>
            <ul>
                <li>We participate in eBay's affiliate program</li>
                <li>When you click on similar product links we provide, eBay may track those clicks and subsequent purchases</li>
                <li>Affiliate tracking is governed by eBay's privacy policy and terms of service</li>
                <li>We earn commissions on qualifying purchases made through affiliate links</li>
            </ul>
        </div>

        <div class="section">
            <h2>Your Rights</h2>
            
            <h3>You Can:</h3>
            <ul>
                <li>Disable or uninstall the Extension at any time through your browser's extension settings</li>
                <li>Choose not to click on the similar listing links we provide</li>
                <li>Browse eBay without the Extension to avoid automatic data collection</li>
                <li>Contact us with privacy questions or concerns at <a href="mailto:estherhuanneli@gmail.com">estherhuanneli@gmail.com</a></li>
            </ul>

            <h3>Data Deletion:</h3>
            <p>Since we do not store your data permanently, there is no persistent data to delete. Once you uninstall the Extension, no further data collection occurs.</p>
        </div>

        <div class="section">
            <h2>Children's Privacy</h2>
            <p>This Extension is not directed at children under 13. We do not knowingly collect information from children.</p>
        </div>

        <div class="section">
            <h2>Changes to This Policy</h2>
            <p>We may update this Privacy Policy from time to time. Changes will be posted with a new "Last Updated" date. We encourage you to review this policy periodically.</p>
        </div>

        <div class="section">
            <h2>Contact Us</h2>
            <p>If you have questions about this Privacy Policy or the Extension's privacy practices, please contact:</p>
            <p><strong>Email:</strong> <a href="mailto:estherhuanneli@gmail.com">estherhuanneli@gmail.com</a></p>
        </div>

        <div class="section">
            <h2>Compliance</h2>
            <p>This Extension complies with:</p>
            <ul>
                <li>Chrome Web Store Developer Program Policies</li>
                <li>U.S. privacy laws and regulations</li>
                <li>eBay Partner Network terms and conditions</li>
            </ul>
        </div>

        <hr style="margin: 30px 0; border: none; border-top: 1px solid #ddd;">
        
        <p style="text-align: center; color: #7f8c8d; font-size: 0.9em;">
            <strong>Note:</strong> By using this Extension, you also agree to eBay's Terms of Use and Privacy Policy when interacting with eBay's platform.
        </p>
    </div>
</body>
</html>
                """;
    }
}