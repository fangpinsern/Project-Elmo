package com.company.utils;

import com.company.base.RelExpr;
import com.company.base.RelFactor;

import java.util.ArrayList;
import java.util.Random;

public class RelExprGen {

    public static ArrayList<RelExpr> existingRelExpr = new ArrayList<>();

    public RelExprGen () {}

    public RelExpr generate() {
        ArrayList<String> relExprOps = RelExpr.getValidOps();
        Random r = new Random();
        int opIndex = r.nextInt(relExprOps.size());
        String relExprOp = relExprOps.get(opIndex);

        int randomIndex = r.nextInt(3);
        RelFactorGen relFactorGen = new RelFactorGen();
        RelExpr newVariable = new RelExpr(relFactorGen.getRandom(), relExprOp, relFactorGen.getRandom());
        this.existingRelExpr.add(newVariable);
        return newVariable;
    }

    public RelExpr getRandomExisting() {
        if (this.existingRelExpr.size() <= 0) {
            return generate();
        }
        int upperLimit = this.existingRelExpr.size();
        Random r = new Random();
        int randomIndex = r.nextInt(upperLimit);

        return this.existingRelExpr.get(randomIndex);
    }

    public RelExpr getRandom() {
        if (this.existingRelExpr.size() <= 0) {
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
                int upperLimit = this.existingRelExpr.size();
                int randomIndex = r.nextInt(upperLimit);

                return this.existingRelExpr.get(randomIndex);
        }
    }
}
