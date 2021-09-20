package com.company.generator;

import com.company.base.ExprVal;
import com.company.base.VarName;
import com.company.baseGenerator.ExprGen;
import com.company.baseGenerator.VarGen;

public class AssignStatement implements Statement {

    private String leftSide;
    private String rightSide;
    private String name = "Assign";

    public AssignStatement(VarName leftSide, ExprVal rightSide) {
        this.leftSide = leftSide.toString();
        this.rightSide = rightSide.toString();
    }

    public AssignStatement(){}

    public void generateStatement() {
        VarGen varGen = new VarGen();
        ExprGen exprGen = new ExprGen();
        this.leftSide = varGen.getRandomExisting().toString();
        this.rightSide = exprGen.getRandom().toString();
        return;
    }

    @Override
    public String infoString() {
        return String.format("%s - %s = %s", this.name, this.leftSide, this.rightSide);
    }

    @Override
    public String toString() {
        return this.leftSide + " = " + this.rightSide + ";";
    }
}
