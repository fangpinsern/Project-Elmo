package com.company.generator;

import com.company.base.VarName;
import com.company.baseGenerator.VarGen;

public class PrintStatement implements Statement{
//    print: ‘print’ var_name’;’
    private String variableName;
    private String name = "print";

    public PrintStatement(VarName variableName) {
        this.variableName = variableName.toString();
    }

    public PrintStatement() {}

    public void generateStatement() {
        VarGen varGen = new VarGen();
        this.variableName = varGen.getRandom().toString();
        return;
    }

    public String infoString() {
        return String.format("%s - %s", this.name, this.variableName);
    }

    @Override
    public String toString() {
        String val = "print " + this.variableName + ";";
        return val;
    }
}
