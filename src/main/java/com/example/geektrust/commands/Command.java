package com.example.geektrust.commands;

import java.util.List;

public interface Command {
    void invoke(List<String> tokens);
}
