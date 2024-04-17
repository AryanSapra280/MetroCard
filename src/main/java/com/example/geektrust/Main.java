package com.example.geektrust;

import com.example.geektrust.configuration.AppConfig;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        System.out.println(args.length);
        try {
            BufferedReader bufferedReader= new BufferedReader(new FileReader(args[0]));
            String input = bufferedReader.readLine();
            while(input != null) {
                List<String> tokens  = Arrays.asList(input.split(" "));
                appConfig.invoke(tokens);
                input = bufferedReader.readLine();
            }
            bufferedReader.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
