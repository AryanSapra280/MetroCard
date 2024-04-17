package com.example.geektrust.services.implementations;


import com.example.geektrust.entities.MetroCard;

import com.example.geektrust.exceptions.InvalidMetroCard;
import com.example.geektrust.repositories.interfaces.IMetroCardRepository;
import com.example.geektrust.services.interfaces.IMetroCard;

import java.util.*;


public class MetroCardImpl implements IMetroCard {
    final private IMetroCardRepository metroCardRepository;
    public MetroCardImpl(final IMetroCardRepository metroCardRepository) {
        this.metroCardRepository = metroCardRepository;
    }
    @Override
    public void create(String metroCardId, Integer balance) {
        Optional<MetroCard> paymentTypeOptional = metroCardRepository.findById(metroCardId);
        if(paymentTypeOptional.isPresent()) {
            MetroCard metroCard = paymentTypeOptional.get();
            metroCard.setBalance(balance);
            metroCardRepository.save(metroCard);
        }

        MetroCard metroCard = new MetroCard(metroCardId,balance);
        metroCardRepository.save(metroCard);
    }

    @Override
    public void save(MetroCard paymentType) {
        metroCardRepository.save(paymentType);
    }

    @Override
    public void delete(MetroCard paymentType) {
        metroCardRepository.delete(paymentType);
    }

    @Override
    public MetroCard getById(String id) {
        Optional<MetroCard>optionalPaymentType = metroCardRepository.findById(id);
        if(optionalPaymentType.isPresent() == false) {
            throw new InvalidMetroCard("Invalid payment method");
        }
        return  optionalPaymentType.get();
    }

}
