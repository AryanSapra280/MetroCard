package com.example.geektrust.entities;

public class MetroCard {
    private final String id;
    private Integer balance;
    private Integer tripCount;
    public MetroCard(final String id, final Integer balance) {
        this.id = id;
        this.balance = balance;
        this.tripCount = 0;
    }

    public String getId() {
        return id;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getTripCount() {
        return tripCount;
    }

    public void setTripCount(Integer tripCount) {
        this.tripCount = tripCount;
    }
}
