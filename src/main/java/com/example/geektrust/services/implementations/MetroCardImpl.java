package com.example.geektrust.services.implementations;


import com.example.geektrust.entities.MetroCard;
import com.example.geektrust.entities.PaymentType;
import com.example.geektrust.exceptions.InvalidMetroCard;
import com.example.geektrust.repositories.interfaces.IPaymentTypeRepository;
import com.example.geektrust.services.interfaces.IPaymentType;

import java.util.*;


public class MetroCardImpl implements IPaymentType {
    final private IPaymentTypeRepository metroCardRepository;
    public MetroCardImpl(final IPaymentTypeRepository metroCardRepository) {
        this.metroCardRepository = metroCardRepository;
    }
    @Override
    public void create(String metroCardId, Integer balance) {
        Optional<PaymentType> paymentTypeOptional = metroCardRepository.findById(metroCardId);
        if(paymentTypeOptional.isPresent()) {
            PaymentType metroCard = paymentTypeOptional.get();
            metroCard.setBalance(balance);
            metroCardRepository.save(metroCard);
        }

        PaymentType metroCard = new MetroCard(metroCardId,balance);
        metroCardRepository.save(metroCard);
    }

    @Override
    public void save(PaymentType paymentType) {
        metroCardRepository.save(paymentType);
    }

    @Override
    public void delete(PaymentType paymentType) {
        metroCardRepository.delete(paymentType);
    }

    @Override
    public PaymentType getById(String id) {
        Optional<PaymentType>optionalPaymentType = metroCardRepository.findById(id);
        if(optionalPaymentType.isPresent() == false) {
            throw new InvalidMetroCard("Invalid payment method");
        }
        return  optionalPaymentType.get();
    }

}
