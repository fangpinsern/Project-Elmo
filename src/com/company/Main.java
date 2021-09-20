package com.company;

import com.company.generator.Program;
import com.company.utils.CLIInput;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world");
        boolean inputValuesValid = CLIInput.CliInputScanner();

        if (inputValuesValid) {
            Program newProg = new Program();
            newProg.generateProgram();
        } else {
            System.out.println("Values you have input are invalid. Pls try again");
        }

    }
}
