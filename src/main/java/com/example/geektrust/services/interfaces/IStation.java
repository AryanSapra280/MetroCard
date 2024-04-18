package com.example.geektrust.services.interfaces;


import com.example.geektrust.entities.Station;
import com.example.geektrust.enums.PassengerType;

import java.util.Optional;

public interface IStation {
    Station saveStation(Station station);
    Station getById(String name);
    void printSummary();
    Station updateAll(Station station, PassengerType passengerType, Integer discount, Integer totalAmount);
}
