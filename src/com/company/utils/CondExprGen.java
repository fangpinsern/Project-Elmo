package com.company.utils;

import com.company.base.CondExpr;
import com.company.base.RelExpr;
import com.company.base.RelFactor;
import com.company.base.TermVal;

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
                newVariable = new CondExpr(condExprGen1.getRandom(), condExprOp, condExprGen1.getRandom());
                break;
        }
        this.existingCondExpr.add(newVariable);
        return newVariable;
    }

    public CondExpr getRandom() {
        if (this.existingCondExpr.size() <= 0) {
            return generate();
        }
        int upperLimit = this.existingCondExpr.size();
        Random r = new Random();
        int randomIndex = r.nextInt(upperLimit);

        return this.existingCondExpr.get(randomIndex);
    }
}
