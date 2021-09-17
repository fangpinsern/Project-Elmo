package com.company.generator;

public class ReadStatement implements Statement{
    private String varName;

    public ReadStatement(String variableName) {
        this.varName = variableName;
    }

    public void generateStatement() {
        return;
    }

    public String toString() {
        String val = "read " + this.varName + ";";
        return val;
    }
}
