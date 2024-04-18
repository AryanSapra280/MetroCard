package com.example.geektrust.repositories;

import com.example.geektrust.entities.MetroCard;
import com.example.geektrust.repositories.implementations.MetroCardRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;


public class MetroCardRepositoryTest {
    @Spy
    public MetroCardRepository metroCardRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void saveTest() {
        String key = "MC1";
        Integer balance = 400;
        MetroCard expectedResult = new MetroCard(key,balance);
        MetroCard actualResult = metroCardRepository.save(expectedResult);
        Assert.assertEquals(expectedResult.getId(),actualResult.getId());
        Assert.assertEquals(expectedResult.getBalance(),actualResult.getBalance());
    }
}
