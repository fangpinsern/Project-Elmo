package com.company.generator;

import com.company.base.CondExpr;
import com.company.base.VarName;

public class PrintStatement implements Statement{
//    print: ‘print’ var_name’;’
    private String variableName;

    public PrintStatement(VarName variableName) {
        this.variableName = variableName.toString();
    }

    public void generateStatement() {
        return;
    }

    @Override
    public String toString() {
        String val = "print " + this.variableName + ";";
        return val;
    }
}
