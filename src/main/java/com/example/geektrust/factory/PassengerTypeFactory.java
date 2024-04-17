package com.example.geektrust.factory;


import com.example.geektrust.enums.PassengerType;

public class PassengerTypeFactory {
    private static final Integer ADULT_FARE = 200;
    private static final Integer SENIOR_CITIZEN_FARE = 100;
    private static final Integer KID_FARE = 50;
    public static Integer getPassengerFare(PassengerType passengerType) {
        Integer tripFare = 0;
        if(PassengerType.ADULT.equals(passengerType)) {
            tripFare = ADULT_FARE;
        }
        else if(PassengerType.SENIOR_CITIZEN.equals(passengerType)) {
            tripFare = SENIOR_CITIZEN_FARE;
        }
        else if(PassengerType.KID.equals(passengerType)) {
            tripFare = KID_FARE;
        }
        return tripFare;
    }
}
