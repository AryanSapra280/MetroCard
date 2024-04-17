package com.example.geektrust.services.implementations;


import com.example.geektrust.entities.MetroCard;
import com.example.geektrust.entities.Station;
import com.example.geektrust.enums.PassengerType;
import com.example.geektrust.factory.DiscountFactory;
import com.example.geektrust.factory.PassengerTypeFactory;
import com.example.geektrust.services.abstractClasses.abstractFareCheck;
import com.example.geektrust.services.interfaces.IMetroCard;
import com.example.geektrust.services.interfaces.IRailwaySystem;
import com.example.geektrust.services.interfaces.IStation;
import com.example.geektrust.strategy.interfaces.DiscountStrategy;

public class RailwaySystemImpl implements IRailwaySystem {
     private final IMetroCard paymentTypeService;
     private final IStation stationService;
     private final abstractFareCheck fareCheck;
     private MetroCard paymentType;
     private Station station;

     public RailwaySystemImpl(final IMetroCard paymentTypeService, final IStation stationService,
                              abstractFareCheck fareCheck) {
         this.paymentTypeService = paymentTypeService;
         this.stationService = stationService;
         this.fareCheck = fareCheck;
     }
    @Override
    public void entry(String paymentMethodId, PassengerType passengerType, String stationName) {
        paymentType = paymentTypeService.getById(paymentMethodId);
        station = stationService.getById(stationName);
        DiscountStrategy discountStrategy = DiscountFactory.getDiscountStrategy("50");
        fareCheck.setDiscountStrategy(discountStrategy);

        calculateTripFare(passengerType);
        //save entities
        paymentTypeService.save(paymentType);
        stationService.saveStation(station);
    }
    private void calculateTripFare(PassengerType passengerType) {
        Integer actualTripPrice = PassengerTypeFactory.getPassengerFare(passengerType);
        Integer tripFee = fareCheck.calculateFare(paymentType,actualTripPrice); // the actual fare amount required.
        Integer discount = actualTripPrice - tripFee;
        Integer recharged = checkRechargeCharge(tripFee,paymentType);
        Integer serviceTax = (recharged * 2 ) / 100;

        stationService.updateAll(station,passengerType,discount,tripFee + serviceTax);
    }
    private Integer checkRechargeCharge(Integer tripFee, MetroCard paymentType) {
         Integer balance = paymentType.getBalance();
         Integer recharge = 0;
         if(balance < tripFee) {
             recharge = tripFee-balance;
             balance = 0;
         }
         else {
             balance -= tripFee;
         }
         paymentType.setBalance(balance);
         return recharge;
    }
}
