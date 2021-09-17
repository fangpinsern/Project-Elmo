package com.company.generator;

import java.util.ArrayList;

public class Program {
    String programName = "SIMPLE";
    ArrayList<String> procedureNames = new ArrayList<String>();
    ArrayList<Procedure> proceduresList = new ArrayList<Procedure>();

    public void generateProgram() {
        Procedure newProc = new Procedure("HELP");
        newProc.generate();
        this.proceduresList.add(newProc);
        System.out.println(proceduresList.get(0).toString());
    }

    @Override
    public String toString() {
        return proceduresList.get(0).toString();
    }
}
