package com.example.geektrust.commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandInvoker implements Command{
    private final Map<String,Command> commandMap;
    private static CommandInvoker commandInvoker = null;
    private CommandInvoker() {
        this.commandMap = new HashMap<>();
    }
    public static CommandInvoker getInstance() {
        if(commandInvoker == null) {
            commandInvoker = new CommandInvoker();
        }
        return commandInvoker;
    }
    public void registerCommand(String commandName,Command command) {
        commandMap.put(commandName,command);
    }
    public void deleteCommand(String commandName) {
        commandMap.remove(commandName);
    }
    @Override
    public void invoke(List<String> tokens) {
        String commandName = tokens.get(0);
        Command command = commandMap.get(commandName);
        command.invoke(tokens);
    }
}
