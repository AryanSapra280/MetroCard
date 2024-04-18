package com.example.geektrust.services;

import com.example.geektrust.entities.MetroCard;
import com.example.geektrust.exceptions.InvalidMetroCard;
import com.example.geektrust.repositories.implementations.MetroCardRepository;
import com.example.geektrust.repositories.interfaces.IMetroCardRepository;
import com.example.geektrust.services.implementations.MetroCardImpl;
import com.example.geektrust.services.interfaces.IMetroCard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

public class MetroCardImpltest {
    @Mock
    public MetroCardRepository metroCardRepository;

    @InjectMocks
    public MetroCardImpl metroCardService;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void metroCardTestWhenPresent() {
        String key = "MC1";
        Integer balance = 600;
        MetroCard expectedResult = new MetroCard(key,balance);
        Optional<MetroCard> metroCard = Optional.ofNullable(new MetroCard("MC1",400));
        Mockito.when(metroCardRepository.findById(Mockito.anyString())).thenReturn(metroCard);
        MetroCard actualResult = metroCardService.create(key,balance);
        Assert.assertEquals(expectedResult.getId(),actualResult.getId());
        Assert.assertEquals(expectedResult.getBalance(),actualResult.getBalance());
    }
    @Test
    public void metroCardTestWhenNotPresent() {
        String key = "MC1";
        Integer balance = 400;
        MetroCard expectedResult = new MetroCard("MC1",400);
        Mockito.when(metroCardRepository.findById(Mockito.anyString())).thenReturn(Optional.ofNullable(null));
        MetroCard actualResult = metroCardService.create(key,balance);
        Assert.assertEquals(expectedResult.getId(),actualResult.getId());
        Assert.assertEquals(expectedResult.getBalance(),actualResult.getBalance());
    }
    @Test
    public void saveTest() {
        MetroCard expectedResult = new MetroCard("MC1",400);
        Mockito.when(metroCardRepository.save(Mockito.any()))
                .thenReturn(expectedResult);
        MetroCard actualResult = metroCardService.save(expectedResult);
        Assert.assertEquals(expectedResult.getId(),actualResult.getId());
        Assert.assertEquals(expectedResult.getBalance(),actualResult.getBalance());
    }

    @Test
    public void getByIdTestWhenPresent() {
        String id = "MC1";
        Integer balance = 400;
        MetroCard expectedResult = new MetroCard(id,balance);
        Mockito.when(metroCardRepository.findById(Mockito.anyString()))
                .thenReturn(Optional.ofNullable(expectedResult));
        MetroCard actualResult = metroCardService.getById(id);
        Assert.assertEquals(expectedResult.getId(),actualResult.getId());
        Assert.assertEquals(expectedResult.getBalance(),actualResult.getBalance());
    }
    @Test
    public void getByIdTestWhenNotPresent() {
        String id = "MC1";
        String exceptionMessage = "Invalid payment method";
        Mockito.when(metroCardRepository.findById(Mockito.anyString()))
                .thenReturn(Optional.ofNullable(null));
        Exception e = Assert.assertThrows(InvalidMetroCard.class,()->metroCardService.getById(id));
        Assert.assertEquals(exceptionMessage,e.getMessage());
    }
}
