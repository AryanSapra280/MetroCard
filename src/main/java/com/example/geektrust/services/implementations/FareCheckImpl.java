package com.example.geektrust.services.implementations;


import com.example.geektrust.entities.MetroCard;
import com.example.geektrust.services.abstractClasses.abstractFareCheck;

public class FareCheckImpl extends abstractFareCheck {

    @Override
    public Integer calculateFare(MetroCard paymentType, Integer tripPrice) {
        Integer tripCount = paymentType.getTripCount();
        if(tripCount.equals(1)) {
            tripPrice = discountStrategy.getDiscountedPrice(tripPrice);
        }
        paymentType.setTripCount((tripCount + 1)%2);
        return tripPrice;
    }

}
