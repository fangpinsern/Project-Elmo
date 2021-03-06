package com.company.baseGenerator;

import com.company.base.RelFactor;

import java.util.ArrayList;
import java.util.Random;

public class RelFactorGen {
    //   rel_factor: var_name | const_value | expr
    public static ArrayList<RelFactor> existingExpr = new ArrayList<>();

    public RelFactorGen () {}

    public RelFactor generate() {
        Random r = new Random();

        int randomIndex = r.nextInt(3);
        RelFactor newVariable;
        switch (randomIndex){
            case 0:
                ExprGen exprGen = new ExprGen();
                newVariable = new RelFactor(exprGen.getRandom());
                break;
            case 1:
                ConstGen constGen = new ConstGen();
                newVariable = new RelFactor(constGen.getRandom());
                break;
            default:
                VarGen varGen = new VarGen();
                newVariable = new RelFactor(varGen.getRandom());
                break;
        }
        this.existingExpr.add(newVariable);
        return newVariable;
    }

    public RelFactor getRandomExisting() {
        if (this.existingExpr.size() <= 0) {
            return generate();
        }
        int upperLimit = this.existingExpr.size();
        Random r = new Random();
        int randomIndex = r.nextInt(upperLimit);

        return this.existingExpr.get(randomIndex);
    }

    public RelFactor getRandom() {
        if (this.existingExpr.size() <= 0) {
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
                int upperLimit = this.existingExpr.size();
                int randomIndex = r.nextInt(upperLimit);

                return this.existingExpr.get(randomIndex);
        }
    }
}
