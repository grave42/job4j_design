package ru.job4j.ood.lsp.foodstore.food;

import java.time.LocalDate;

public abstract class Food {

    private String name;

    private LocalDate expiryDate;

    private LocalDate createDate;

    private double price;

    private final double discount = 0.8;

    public Food(String name, LocalDate expiryDate, LocalDate createDate, double price) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public double calculateExpirationPercentage() {
        LocalDate currentDate = LocalDate.now();
        long totalDays = expiryDate.toEpochDay() - createDate.toEpochDay();
        long daysPassed = currentDate.toEpochDay() - createDate.toEpochDay();
        double percentage = (double) daysPassed / totalDays * 100;
        return Math.min(100, percentage);
    }

    public void makeDiscount() {
        this.price = price * discount;
    }
}

