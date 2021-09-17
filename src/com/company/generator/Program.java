package com.company.generator;

import com.company.base.ProcName;
import com.company.utils.ProcGen;

import java.util.ArrayList;

public class Program {
    String programName = "SIMPLE";
    ArrayList<String> procedureNames = new ArrayList<String>();
    ArrayList<Procedure> proceduresList = new ArrayList<Procedure>();

    public void generateProgram() {
        ProcGen proc = new ProcGen();
        Procedure newProc = new Procedure(proc.generateProcName());
        newProc.generate();
        this.proceduresList.add(newProc);
        System.out.println(proceduresList.get(0).toString());
    }

    @Override
    public String toString() {
        return proceduresList.get(0).toString();
    }
}
