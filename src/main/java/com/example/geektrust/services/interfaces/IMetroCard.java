package com.example.geektrust.services.interfaces;


import com.example.geektrust.entities.MetroCard;


public interface IMetroCard {
    MetroCard create(String metroCardId,Integer balance);
    MetroCard save(MetroCard paymentType);
    void delete(MetroCard paymentType);
    MetroCard getById(String id);

}
