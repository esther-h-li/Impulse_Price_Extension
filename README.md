# Impulse Price Checker

Impulse Price Checker is a Chrome extension that helps users quickly compare prices for items on eBay. While viewing a listing, it finds similar products and displays comparable prices so users can make faster, more informed purchasing decisions.

The goal is to reduce impulse purchases and give both buyers and sellers quick market context without leaving the page.

---

## Features

* Detects the current eBay listing automatically
* Finds similar listings using backend-powered search
* Displays results sorted by price (low to high)
* One-click access from the browser extension
* Lightweight and runs only when needed

---

## Tech Stack

**Extension**

* JavaScript
* Chrome Extension APIs
* MutationObserver

**Backend**

* Java
* Spring Boot
* OkHttp
* eBay Browse API

**Deployment**

* Google Cloud Run

---

## Architecture

Chrome Extension → Spring Boot Backend → eBay Browse API

The extension extracts product information from the active page and sends it to a backend service. The backend queries the eBay API, processes results, and returns matched listings for display in the popup UI.

---

## Setup

### 1. Clone repository

```bash id="c1q8ka"
git clone https://github.com/esther-h-li/impulse-price-checker.git
cd impulse-price-checker
```

### 2. eBay API credentials

Create an application on the eBay Developer Portal and obtain:

* Client ID
* Client Secret

Set them as environment variables:

```bash id="k2m8pz"
EBAY_CLIENT_ID=your_client_id
EBAY_CLIENT_SECRET=your_client_secret
```

---

## Running locally

### Backend

```bash id="n9x2vd"
cd backend
./mvnw spring-boot:run
```

### Extension

Load the unpacked extension in `chrome://extensions` and point it to `http://localhost:8080`.

---

## Deployment (Cloud Run)

1. Build backend:

```bash id="r4t7lm"
./mvnw clean package
```

2. Deploy to Cloud Run:

```bash id="p6v1sz"
gcloud builds submit --tag gcr.io/YOUR_PROJECT_ID/impulse-price-checker

gcloud run deploy impulse-price-checker \
  --image gcr.io/YOUR_PROJECT_ID/impulse-price-checker \
  --platform managed \
  --allow-unauthenticated
```

3. Add environment variables in Cloud Run:

* `EBAY_CLIENT_ID`
* `EBAY_CLIENT_SECRET`

4. Update extension backend URL to the deployed service endpoint.

---

## Limitations

* eBay only (no multi-platform support yet)
* Matching quality depends on listing data consistency
* Not all products return comparable results

---

## Future Work

* Support for other marketplaces (Amazon, Etsy, AliExpress)
* Improved product matching logic
* Price history tracking
* UI improvements in extension popup

