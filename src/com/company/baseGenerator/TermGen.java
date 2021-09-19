package com.company.baseGenerator;

import com.company.base.TermVal;

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
                newVariable = new TermVal(termGen.generate(), termOp, factorGen.generate());
                break;
            default:
                FactorGen factorGen2 = new FactorGen();
                newVariable = new TermVal(factorGen2.generate());
                break;
        }
        this.existingTerms.add(newVariable);
        return newVariable;
    }

    public TermVal getRandomExisting() {
        if (this.existingTerms.size() <= 0) {
            return generate();
        }
        int upperLimit = this.existingTerms.size();
        Random r = new Random();
        int randomIndex = r.nextInt(upperLimit);

        return this.existingTerms.get(randomIndex);
    }

    public TermVal getRandom() {
        if (this.existingTerms.size() <= 0) {
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
                int upperLimit = this.existingTerms.size();
                int randomIndex = r.nextInt(upperLimit);

                return this.existingTerms.get(randomIndex);
        }
    }
}
