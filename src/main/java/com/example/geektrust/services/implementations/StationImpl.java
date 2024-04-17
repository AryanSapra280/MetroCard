package com.example.geektrust.services.implementations;

import com.example.geektrust.entities.Station;
import com.example.geektrust.enums.PassengerType;
import com.example.geektrust.exceptions.InvalidStation;
import com.example.geektrust.repositories.interfaces.IStationRepository;
import com.example.geektrust.services.interfaces.IStation;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StationImpl implements IStation {
    private final IStationRepository stationRepository;
    public StationImpl(final IStationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }
    @Override
    public void saveStation(Station station) {
        stationRepository.save(station);
    }

    @Override
    public Station getById(String name) {
        Optional<Station> optionalStation = stationRepository.findById(name);
        if(optionalStation.isPresent() == false) {
            throw new InvalidStation("Station not found");
        }
        return optionalStation.get();
    }

    @Override
    public void updateAll(Station station, PassengerType passengerType, Integer discount, Integer totalAmount) {
        station.addPassenger(passengerType);
        station.setDiscount(discount);
        station.setAmount(totalAmount);
    }
    @Override
    public void printSummary() {
        List<Station> stations = stationRepository.findAll();
        for(Station station:stations) {
            System.out.print(getSummary(station));
        }
    }
    private String getSummary(Station station) {
        StringBuilder summary = new StringBuilder();
        summary.append("TOTAL_COLLECTION ").append(station.getName() + " ").append(station.getTotalAmount() + " ")
                .append(station.getTotalDiscount() + "\n");
        summary.append("PASSENGER_TYPE_SUMMARY\n");
        for(Map.Entry<PassengerType,Integer>e:station.getPassengerCount().entrySet()) {
            summary.append(String.valueOf(e.getKey()) + " ").append(e.getValue() + "\n");
        }
        return summary.toString();
    }

}
