package com.example.geektrust.services;

import com.example.geektrust.entities.MetroCard;
import com.example.geektrust.entities.Station;
import com.example.geektrust.enums.PassengerType;
import com.example.geektrust.services.implementations.FareCheckImpl;
import com.example.geektrust.services.implementations.MetroCardImpl;
import com.example.geektrust.services.implementations.RailwaySystemImpl;
import com.example.geektrust.services.implementations.StationImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class StationImplTest {

    @Mock
    public MetroCardImpl metroCardImpl;
    @Mock
    public StationImpl stationImpl;
    @Mock
    public FareCheckImpl fareCheckImpl;

    @InjectMocks
    public RailwaySystemImpl railwaySystem;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void entryTest() {
        String metroCardId = "MC1";
        String stationName = "AIRPORT";
        PassengerType passengerType = PassengerType.ADULT;
        Station station = new Station(stationName);
        MetroCard metroCard = new MetroCard(metroCardId,400);
        Mockito.when(metroCardImpl.getById(Mockito.anyString())).thenReturn(metroCard);
        Mockito.when(stationImpl.getById(Mockito.anyString())).thenReturn(station);
        Mockito.when(metroCardImpl.save(Mockito.any())).thenReturn(metroCard);
        Mockito.when(stationImpl.saveStation(Mockito.any())).thenReturn(station);
        railwaySystem.entry(metroCardId,passengerType,stationName);
        Mockito.verify(stationImpl,Mockito.times(1)).saveStation(station);
    }
    @Test
    public void updateAllTest() {
        String stationName = "AIRPORT";
        Integer amount = 100;
        Integer discount = 0;
        PassengerType passengerType = PassengerType.SENIOR_CITIZEN;
        Station expectedResult = new Station(stationName);
        expectedResult.setAmount(amount);
        expectedResult.setDiscount(discount);
        expectedResult.addPassenger(passengerType);
        Station station = new Station(stationName);
        Mockito.when(stationImpl.updateAll(station,passengerType,discount,amount)).thenReturn(expectedResult);
        Station actualResult = stationImpl.updateAll(station,passengerType,discount,amount);
        Assert.assertEquals(actualResult.getPassengerCount().size(),expectedResult.getPassengerCount().size());
        Assert.assertEquals(actualResult.getTotalAmount(),expectedResult.getTotalAmount());
        Assert.assertEquals(actualResult.getName(),expectedResult.getName());

    }
}
