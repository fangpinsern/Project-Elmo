package com.company.utils;

import com.company.base.ExprVal;
import com.company.base.TermVal;

import java.util.ArrayList;
import java.util.Random;

public class ExprGen {
//    expr ‘+’ term | expr ‘-’ term | term
    public static ArrayList<ExprVal> existingExpr = new ArrayList<>();

    public ExprGen () {}

    public ExprVal generate() {
        ArrayList<String> exprOps = ExprVal.getValidOps();
        Random r = new Random();
        int opIndex = r.nextInt(exprOps.size());
        String termOp = exprOps.get(opIndex);

        int randomIndex = r.nextInt(3);
        ExprVal newVariable;
        switch (randomIndex){
            case 0:
                TermGen termGen = new TermGen();
                ExprGen exprGen = new ExprGen();
                newVariable = new ExprVal(exprGen.getRandom(), termOp, termGen.generate());
                break;
            default:
                TermGen termGen2 = new TermGen();
                newVariable = new ExprVal(termGen2.generate());
                break;
        }
        this.existingExpr.add(newVariable);
        return newVariable;
    }

    public ExprVal getRandom() {
        if (this.existingExpr.size() <= 0) {
            return generate();
        }
        int upperLimit = this.existingExpr.size();
        Random r = new Random();
        int randomIndex = r.nextInt(upperLimit);

        return this.existingExpr.get(randomIndex);
    }
}
