package com.company.utils;

import com.company.base.Factor;
import com.company.base.ProcName;
import com.company.base.VarName;

import java.util.ArrayList;
import java.util.Random;

public class FactorGen {
    public static ArrayList<Factor> existingFactor = new ArrayList<>();

    public Factor generate() {
        Random r = new Random();
        int randomIndex = r.nextInt(3);
        Factor newVariable;
        switch (randomIndex){
            case 0:
                ConstGen constGen= new ConstGen();
                newVariable = new Factor(constGen.generate());
                break;
            case 1:
                ExprGen exprGen= new ExprGen();
                newVariable = new Factor(exprGen.getRandom());
                break;
            default:
                VarGen varGen= new VarGen();
                newVariable = new Factor(varGen.generate());
                break;
        }
        this.existingFactor.add(newVariable);
        return newVariable;
    }

    public Factor getRandom() {
        if (this.existingFactor.size() <= 0) {
            generate();
        }
        int upperLimit = this.existingFactor.size();
        Random r = new Random();
        int randomIndex = r.nextInt(upperLimit);

        return this.existingFactor.get(randomIndex);
    }
}
