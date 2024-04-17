package com.example.geektrust.services.interfaces;


import com.example.geektrust.enums.PassengerType;

public interface IRailwaySystem {
    void entry(String paymentMethodId, PassengerType passengerType, String station);
}
