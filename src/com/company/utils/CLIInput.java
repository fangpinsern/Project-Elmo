package com.company.utils;

import java.util.Scanner;

public class CLIInput {
    public static int nestingLevel;
    public static int seedValue;
    public static boolean randomiseNoOfLines;

    public static boolean CliInputScanner() {
        boolean valuesValid = true;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Nesting level: ");
        if(scanner.hasNextInt()){
            nestingLevel = scanner.nextInt();
        }else{
            valuesValid = false;
            System.out.println("InvalidInteger");
        }

        System.out.print("Enter Seed value: ");
        if(scanner.hasNextInt()){
            seedValue = scanner.nextInt();
        }else{
            valuesValid = false;
            System.out.println("InvalidInteger");
        }

        System.out.print("Random number of lines? (true/false): ");
        if(scanner.hasNextBoolean()){
            randomiseNoOfLines = scanner.nextBoolean();
        }else{
            valuesValid = false;
            System.out.println("InvalidInteger");
        }
        return valuesValid;
    }
}
