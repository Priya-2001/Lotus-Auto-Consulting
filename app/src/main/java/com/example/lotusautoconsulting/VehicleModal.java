package com.example.lotusautoconsulting;
public class VehicleModal {
    private String reg;
    private String brand;
    private String variant;
    private String model;
    private String date;
    private int amount;
    private String expiry;
    private String status;

    public String getRegistrationNumber() {
        return reg;
    }

    public void setRegistrationNumber(String reg) {
        this.reg = reg;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) { this.model = model; }

    public String getDate() {
        return date;
    }

    public void setDate(String date) { this.date = date; }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) { this.expiry = expiry; }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) { this.status = status; }
    public VehicleModal(String reg, String brand, String variant, String model, String date, int amount, String expiry, String status) {
        this.reg = reg;
        this.brand = brand;
        this.variant = variant;
        this.model = model;
        this.date = date;
        this.amount = amount;
        this.expiry = expiry;
        this.status = status;
    }
}