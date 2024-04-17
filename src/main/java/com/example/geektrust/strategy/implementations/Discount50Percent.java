package com.example.geektrust.strategy.implementations;


import com.example.geektrust.strategy.interfaces.DiscountStrategy;

public class Discount50Percent implements DiscountStrategy {
    @Override
    public Integer getDiscountedPrice(Integer price) {
        price = price / 2;
        return price;
    }
}
