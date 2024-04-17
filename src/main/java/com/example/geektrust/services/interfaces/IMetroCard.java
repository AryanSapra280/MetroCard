package com.example.geektrust.services.interfaces;


import com.example.geektrust.entities.MetroCard;


public interface IMetroCard {
    void create(String metroCardId,Integer balance);
    void save(MetroCard paymentType);
    void delete(MetroCard paymentType);
    MetroCard getById(String id);

}
