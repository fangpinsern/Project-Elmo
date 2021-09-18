package com.company.generator;

import com.company.base.VarName;

public class ReadStatement implements Statement{
    private String varName;

    public ReadStatement(VarName variableName) {
        this.varName = variableName.toString();
    }

    public void generateStatement() {
        return;
    }

    public String toString() {
        String val = "read " + this.varName + ";";
        return val;
    }
}
