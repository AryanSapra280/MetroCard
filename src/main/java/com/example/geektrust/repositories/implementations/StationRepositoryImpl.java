package com.example.geektrust.repositories.implementations;



import com.example.geektrust.entities.Station;
import com.example.geektrust.repositories.interfaces.IStationRepository;

import java.util.HashMap;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class StationRepositoryImpl implements IStationRepository {
    private final Map<String, Station>stationMap = new LinkedHashMap<>();
    public StationRepositoryImpl() {
        stationMap.put("CENTRAL",new Station("CENTRAL"));
        stationMap.put("AIRPORT",new Station("AIRPORT"));

    }
    @Override
    public Station save(Station entity) {
        stationMap.put(entity.getName(),entity);
        return entity;
    }

    @Override
    public Optional<Station> findById(String name) {
        Optional<Station>optionalStation = Optional.ofNullable(stationMap.get(name));
        if(optionalStation.isPresent() == false) {
            Station newStation = save(new Station(name));
            optionalStation = Optional.ofNullable(newStation);
        }
        return optionalStation;
    }

    @Override
    public List<Station> findAll() {
        return stationMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Boolean isPresent(String name) {
        return findById(name).isPresent();
    }

    @Override
    public void delete(Station entity) {
        stationMap.remove(entity.getName());
    }
}
