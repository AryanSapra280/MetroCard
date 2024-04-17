package com.example.geektrust.factory;


import com.example.geektrust.enums.PassengerType;

public class PassengerTypeFactory {
    public static Integer getPassengerFare(PassengerType passengerType) {
        Integer tripFare = 0;
        if(PassengerType.ADULT.equals(passengerType)) {
            tripFare = 200;
        }
        else if(PassengerType.SENIOR_CITIZEN.equals(passengerType)) {
            tripFare = 100;
        }
        else if(PassengerType.KID.equals(passengerType)) {
            tripFare = 50;
        }
        return tripFare;
    }
}
