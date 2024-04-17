package com.example.geektrust.repositories.implementations;


import com.example.geektrust.entities.PaymentType;
import com.example.geektrust.repositories.interfaces.IPaymentTypeRepository;

import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class PaymentTypeRepository implements IPaymentTypeRepository {
    final Map<String, PaymentType> paymentTypeMap = new HashMap<>();

    @Override
    public PaymentType save(PaymentType entity) {
        paymentTypeMap.put(entity.getId(),entity);
        return entity;
    }

    @Override
    public Optional<PaymentType> findById(String metroCardId) {
        Optional<PaymentType>optionalPaymentMethod = Optional.ofNullable(paymentTypeMap.get(metroCardId));
        return optionalPaymentMethod;
    }

    @Override
    public List<PaymentType> findAll() {
        return paymentTypeMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Boolean isPresent(String metroCardId) {
        Optional<PaymentType>paymentMethod = findById(metroCardId);
        return paymentMethod.isPresent();
    }

    @Override
    public void delete(PaymentType entity) {
        paymentTypeMap.remove(entity.getId());
    }
}
