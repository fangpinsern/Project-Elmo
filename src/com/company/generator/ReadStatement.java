package com.company.generator;

import com.company.base.VarName;
import com.company.baseGenerator.VarGen;

public class ReadStatement implements Statement{
    private String varName;
    private String name = "Read";

    public ReadStatement(VarName variableName) {
        this.varName = variableName.toString();
    }

    public ReadStatement(){}

    public void generateStatement() {
        VarGen varGen = new VarGen();
        this.varName = varGen.getRandom().toString();
        return;
    }

    public String infoString() {
        return String.format("%s - %s", this.name, this.varName);
    }

    public String toString() {
        String val = "read " + this.varName + ";";
        return val;
    }
}
