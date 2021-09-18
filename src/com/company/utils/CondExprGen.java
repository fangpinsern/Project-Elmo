package com.company.utils;

import com.company.base.*;

import java.util.ArrayList;
import java.util.Random;

public class CondExprGen {
//    rel_expr | ‘!’ ‘(’ cond_expr ‘)’ | ‘(’ cond_expr ‘)’ ‘&&’ ‘(’ cond_expr ‘)’ |
//    ‘(’ cond_expr ‘)’ ‘||’ ‘(’ cond_expr ‘)’
    public static ArrayList<CondExpr> existingCondExpr = new ArrayList<>();

    public CondExprGen () {}

    public CondExpr generate() {

        ArrayList<String> condExprOps = CondExpr.getValidOps();
        Random r = new Random();
        int opIndex = r.nextInt(condExprOps.size());
        String condExprOp = condExprOps.get(opIndex);

        int randomIndex = r.nextInt(3);
        CondExpr newVariable;
        switch (randomIndex){
            case 0:
                RelExprGen relExprGen = new RelExprGen();
                newVariable = new CondExpr(relExprGen.getRandom());
                break;
            case 1:
                CondExprGen condExprGen = new CondExprGen();
                newVariable = new CondExpr(condExprGen.getRandom());
                break;
            default:
                CondExprGen condExprGen1 = new CondExprGen();
                newVariable = new CondExpr(condExprGen1.getRandomExisting(), condExprOp, condExprGen1.getRandomExisting());
                break;
        }
        this.existingCondExpr.add(newVariable);
        return newVariable;
    }

    public CondExpr getRandomExisting() {
        if (this.existingCondExpr.size() <= 0) {
            return generate();
        }
        int upperLimit = this.existingCondExpr.size();
        Random r = new Random();
        int randomIndex = r.nextInt(upperLimit);

        return this.existingCondExpr.get(randomIndex);
    }

    public CondExpr getRandom() {

        if (this.existingCondExpr.size() <= 0) {
            return generate();
        }
        // choice of getting random new variable or existing variable
        // random form 0-2, favouring existing variable
        Random r = new Random();
        int existingOrNew = r.nextInt(3);
        switch (existingOrNew) {
            case 0:
                return generate();
            default:
                int upperLimit = this.existingCondExpr.size();
                int randomIndex = r.nextInt(upperLimit);

                return this.existingCondExpr.get(randomIndex);
        }
    }
}
