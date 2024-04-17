package com.example.geektrust.repositories.implementations;


import com.example.geektrust.entities.MetroCard;

import com.example.geektrust.repositories.interfaces.IMetroCardRepository;

import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class MetroCardRepository implements IMetroCardRepository {
    final Map<String, MetroCard> paymentTypeMap = new HashMap<>();

    @Override
    public MetroCard save(MetroCard entity) {
        paymentTypeMap.put(entity.getId(),entity);
        return entity;
    }

    @Override
    public Optional<MetroCard> findById(String metroCardId) {
        Optional<MetroCard>optionalPaymentMethod = Optional.ofNullable(paymentTypeMap.get(metroCardId));
        return optionalPaymentMethod;
    }

    @Override
    public List<MetroCard> findAll() {
        return paymentTypeMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Boolean isPresent(String metroCardId) {
        Optional<MetroCard>paymentMethod = findById(metroCardId);
        return paymentMethod.isPresent();
    }

    @Override
    public void delete(MetroCard entity) {
        paymentTypeMap.remove(entity.getId());
    }
}
