package com.example.geektrust.commands;



import com.example.geektrust.services.interfaces.IStation;

import java.util.List;

public class PrintSummary implements Command{
    private final IStation station;
    public PrintSummary(final IStation station) {
        this.station = station;
    }
    @Override
    public void invoke(List<String> tokens) {
        station.printSummary();
    }
}
