package com.example.geektrust.configuration;



import com.example.geektrust.commands.Balance;
import com.example.geektrust.commands.CheckIn;
import com.example.geektrust.commands.CommandInvoker;
import com.example.geektrust.commands.PrintSummary;
import com.example.geektrust.repositories.implementations.MetroCardRepository;
import com.example.geektrust.repositories.implementations.StationRepositoryImpl;
import com.example.geektrust.repositories.interfaces.IMetroCardRepository;
import com.example.geektrust.repositories.interfaces.IStationRepository;
import com.example.geektrust.services.abstractClasses.abstractFareCheck;
import com.example.geektrust.services.implementations.FareCheckImpl;
import com.example.geektrust.services.implementations.MetroCardImpl;
import com.example.geektrust.services.implementations.RailwaySystemImpl;
import com.example.geektrust.services.implementations.StationImpl;
import com.example.geektrust.services.interfaces.IMetroCard;
import com.example.geektrust.services.interfaces.IRailwaySystem;
import com.example.geektrust.services.interfaces.IStation;

import java.util.List;

public class AppConfig {
    //Dependencies decalared
    private final IMetroCardRepository paymentMethodRepository = new MetroCardRepository();
    private final IStationRepository stationRepository = new StationRepositoryImpl();
    private final abstractFareCheck fareCheck = new FareCheckImpl();

    //Dependent declared
    private final IMetroCard metroCard = new MetroCardImpl(paymentMethodRepository);
    private final IStation station = new StationImpl(stationRepository);
    private final IRailwaySystem stationSystem = new RailwaySystemImpl(metroCard,station,fareCheck);

    //Commands Declared
    private final Balance balance = new Balance(metroCard);
    private final CheckIn checkin = new CheckIn(stationSystem);
    private final PrintSummary printSummary = new PrintSummary(station);

    //CommandInvoker declared
    private final CommandInvoker commandInvoker = CommandInvoker.getInstance();

    public AppConfig() {
        commandInvoker.registerCommand("BALANCE",balance);
        commandInvoker.registerCommand("CHECK_IN",checkin);
        commandInvoker.registerCommand("PRINT_SUMMARY",printSummary);
    }

    public void invoke(List<String> tokens) {
        commandInvoker.invoke(tokens);
    }
}
