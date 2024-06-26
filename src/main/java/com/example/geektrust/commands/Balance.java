package com.example.geektrust.commands;


import com.example.geektrust.services.interfaces.IMetroCard;

import java.util.List;

public class Balance implements Command{
    private final IMetroCard metroCard;
    public Balance(final IMetroCard metroCard) {
        this.metroCard = metroCard;
    }
    @Override
    public void invoke(List<String> tokens) {
        String metroCardId = tokens.get(1);
        Integer balance = Integer.parseInt(tokens.get(2));
        metroCard.create(metroCardId,balance);
    }
}
