package com.fetchchallenge.fetchchallenge;

import java.util.List;
import java.util.UUID;

public class Receipt {

    private UUID id;
    private String retailer;
    private String purchaseDate;
    private String purchaseTime;
    private List<Item> items;
    private String total;

    public Receipt() {}

    public Receipt(UUID id, String retailer, String purchaseDate, String purchaseTime, List<Item> items, String total) {
        this.id = id;
        this.retailer = retailer;
        this.purchaseDate = purchaseDate;
        this.purchaseTime = purchaseTime;
        this.items = items;
        this.total = total;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getRetailer() {
        return retailer;
    }

    public void setRetailer(String retailer) {
        this.retailer = retailer;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(String purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public static class Item {
        private String shortDescription;
        private Double price;

        // Default constructor
        public Item() {
        }

        // Parameterized constructor
        public Item(String shortDescription, Double price) {
            this.shortDescription = shortDescription;
            this.price = price;
        }

        // Getters and setters

        public String getShortDescription() {
            return shortDescription;
        }

        public void setShortDescription(String shortDescription) {
            this.shortDescription = shortDescription;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }
    }
}
