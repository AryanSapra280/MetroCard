package com.example.geektrust.services.interfaces;


import com.example.geektrust.entities.PaymentType;

public interface IPaymentType {
    void create(String metroCardId,Integer balance);
    void save(PaymentType paymentType);
    void delete(PaymentType paymentType);
    PaymentType getById(String id);

}
