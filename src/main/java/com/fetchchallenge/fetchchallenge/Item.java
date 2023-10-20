package com.fetchchallenge.fetchchallenge;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEMID")
    private Integer itemId;
    @ManyToOne
    @JoinColumn(name = "RECEIPT_ID")
    @JsonIgnore
    private Receipt receipt;

    @Column(name = "SHORTDESCRIPTION")
    private String shortDescription;
    @Column(name = "PRICE")
    private Double price;

    public Item() {
    }

    // Parameterized constructor
    public Item(Receipt receipt, String shortDescription, Double price) {
        this.receipt = receipt;
        this.shortDescription = shortDescription;
        this.price = price;
    }

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

    public Receipt getReceipt() { return this.receipt; }

    public void setReceipt(Receipt receipt) { this.receipt = receipt; }

}