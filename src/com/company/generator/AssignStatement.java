package com.company.generator;

import com.company.base.ExprVal;
import com.company.base.VarName;

public class AssignStatement implements Statement {

    private String leftSide;
    private String rightSide;

    public AssignStatement(VarName leftSide, ExprVal rightSide) {
        this.leftSide = leftSide.toString();
        this.rightSide = rightSide.toString();
    }

    public void generateStatement() {
        return;
    }

    @Override
    public String toString() {
        return this.leftSide + " = " + this.rightSide + ";";
    }
}
