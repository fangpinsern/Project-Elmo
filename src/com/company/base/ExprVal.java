package com.company.base;

import java.util.ArrayList;
import java.util.Arrays;

public class ExprVal {

//    expr ‘+’ term | expr ‘-’ term | term
    private String leftVal;
    private String rightVal;
    private String op;

    private ArrayList<String> validOps = new ArrayList<>(Arrays.asList(
            "+",
            "-"
    ));

    public ExprVal (ExprVal left, String op, TermVal right){
        this.leftVal = left.toString();
        this.rightVal = right.toString();
        this.op = op;
        if (op != "+" && op != "-") {
            System.out.println("WARNING - INVALID EXPR OP");
        }
    }

    public ArrayList<String> getValidOps(){
        return this.validOps;
    }

    @Override
    public String toString() {
        return this.leftVal + this.op + this.rightVal;
    }
}

