package com.company.generator;

import com.company.baseGenerator.ConstGen;
import com.company.baseGenerator.ExprGen;
import com.company.baseGenerator.ProcGen;
import com.company.baseGenerator.VarGen;
import com.company.utils.Formatter;

import java.util.ArrayList;

public class Program {
    String programName = "SIMPLE";
    ArrayList<String> procedureNames = new ArrayList<String>();
    ArrayList<Procedure> proceduresList = new ArrayList<Procedure>();

    public void generateProgram() {
        ProcGen proc = new ProcGen();
        Procedure newProc = new Procedure(proc.generate());
        newProc.generate();
        this.proceduresList.add(newProc);
        String formattedOut = Formatter.formatSIMPLE(proceduresList.get(0).toString());
        System.out.println(formattedOut);
        System.out.println(VarGen.existingVar);
        System.out.println(ConstGen.existingConst);
        System.out.println(ExprGen.existingExpr);
    }

    @Override
    public String toString() {
        return proceduresList.get(0).toString();
    }
}
