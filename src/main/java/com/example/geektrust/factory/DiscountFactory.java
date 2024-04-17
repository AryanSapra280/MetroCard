package com.example.geektrust.factory;


import com.example.geektrust.strategy.implementations.Discount50Percent;
import com.example.geektrust.strategy.interfaces.DiscountStrategy;

public class DiscountFactory {

    public static DiscountStrategy getDiscountStrategy(String discount) {
        DiscountStrategy discountStrategy = null;
        if("50".equals(discount)) {
            discountStrategy = new Discount50Percent();
        }
        return discountStrategy;
    }
}
