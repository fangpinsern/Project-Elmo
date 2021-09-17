package com.company.generator;

public class AssignStatement implements Statement {

    private String leftSide;
    private String rightSide;

    public AssignStatement(String leftSide, String rightSide) {
        this.leftSide = leftSide;
        this.rightSide = rightSide;
    }

    public void generateStatement() {
        return;
    }

    @Override
    public String toString() {
        return this.leftSide + " = " + this.rightSide + ";";
    }
}
