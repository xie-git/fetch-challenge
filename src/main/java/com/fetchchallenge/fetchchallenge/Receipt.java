package com.fetchchallenge.fetchchallenge;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "receipts")
public class Receipt {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "ID", updatable = false, nullable = false)
    private UUID receipt_id;
    @Column(name = "RETAILER")
    private String retailer;
    @Column(name = "PURCHASEDATE")
    private String purchaseDate;
    @Column(name = "PURCHASETIME")
    private String purchaseTime;
    @OneToMany(mappedBy = "receipt", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Item> items = new ArrayList<>();
    @Column(name = "TOTAL")
    private String total;

    public Receipt() {

    }


    public Receipt(UUID receipt_id, String retailer, String purchaseDate, String purchaseTime, String total) {
        this.receipt_id = receipt_id;
        this.retailer = retailer;
        this.purchaseDate = purchaseDate;
        this.purchaseTime = purchaseTime;
        this.total = total;
    }

    public UUID getId() {
        return receipt_id;
    }

    public void setId(UUID id) {
        this.receipt_id = id;
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

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
