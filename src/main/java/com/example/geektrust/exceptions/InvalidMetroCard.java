package com.example.geektrust.exceptions;

public class InvalidMetroCard extends RuntimeException{
    public InvalidMetroCard() {
        super();
    }
    public InvalidMetroCard(String msg) {
        super(msg);
    }
}
