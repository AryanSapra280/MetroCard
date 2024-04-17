package com.example.geektrust.commands;



import com.example.geektrust.enums.PassengerType;
import com.example.geektrust.services.interfaces.IRailwaySystem;

import java.util.List;

public class CheckIn implements Command{
    private final IRailwaySystem stationSystem;
    public CheckIn(final IRailwaySystem stationSystem) {
        this.stationSystem = stationSystem;
    }
    @Override
    public void invoke(List<String> tokens) {
        String metroCardId = tokens.get(1);
        PassengerType passengerType = PassengerType.valueOf(tokens.get(2));
        String station = tokens.get(3);

        stationSystem.entry(metroCardId,passengerType,station);
    }
}
