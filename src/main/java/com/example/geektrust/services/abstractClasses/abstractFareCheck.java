package com.example.geektrust.services.abstractClasses;


import com.example.geektrust.entities.MetroCard;
import com.example.geektrust.strategy.interfaces.DiscountStrategy;

public abstract class abstractFareCheck {
    protected DiscountStrategy discountStrategy;
    public abstract Integer calculateFare(MetroCard paymentType, Integer tripPrice);

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

}
