package com.example.geektrust.entities;


import com.example.geektrust.enums.PassengerType;

import java.util.*;

public class Station {
    private final String name;
    private Integer totalAmount = 0;
    private Integer totalDiscount = 0;
    private final Map<PassengerType,Integer> passengerCount;

    public Station(String name) {
        this.name = name;
        this.passengerCount = new TreeMap<>();
    }

    public String getName() {
        return name;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public Integer getTotalDiscount() {
        return totalDiscount;
    }

    public Map<PassengerType, Integer> getPassengerCount() {
        return passengerCount;
    }

    public void setAmount(Integer amount) {
        this.totalAmount += amount;
    }
    public void setDiscount(Integer discount) {
        this.totalDiscount += discount;
    }
    public void addPassenger(PassengerType passengerType) {
        passengerCount.putIfAbsent(passengerType,0);
        passengerCount.put(passengerType,passengerCount.get(passengerType)+1);
    }
}
