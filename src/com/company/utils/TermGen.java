package com.company.utils;

import com.company.base.Factor;
import com.company.base.ProcName;
import com.company.base.TermVal;
import com.company.base.VarName;

import java.util.ArrayList;
import java.util.Random;

public class TermGen {
//    term ‘*’ factor | term ‘/’ factor | term ‘%’ factor | factor
    public static ArrayList<TermVal> existingTerms = new ArrayList<>();

    public TermGen () {}

    public TermVal generate() {
        ArrayList<String> termOps = TermVal.getValidOps();
        Random r = new Random();
        int opIndex = r.nextInt(termOps.size());
        String termOp = termOps.get(opIndex);

        int randomIndex = r.nextInt(3);
        TermVal newVariable;
        switch (randomIndex){
            case 0:
                TermGen termGen = new TermGen();
                FactorGen factorGen = new FactorGen();
                newVariable = new TermVal(termGen.generate(), termOp, factorGen.generateFactor());
                break;
            default:
                FactorGen factorGen2 = new FactorGen();
                newVariable = new TermVal(factorGen2.generateFactor());
                break;
        }
        this.existingTerms.add(newVariable);
        return newVariable;
    }

    public TermVal getRandom() {
        if (this.existingTerms.size() <= 0) {
            return generate();
        }
        int upperLimit = this.existingTerms.size();
        Random r = new Random();
        int randomIndex = r.nextInt(upperLimit);

        return this.existingTerms.get(randomIndex);
    }
}
