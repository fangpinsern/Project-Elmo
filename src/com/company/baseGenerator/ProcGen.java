package com.company.baseGenerator;

import com.company.base.ProcName;

import java.util.ArrayList;
import java.util.Random;

public class ProcGen {
    public static ArrayList<ProcName> existingProc = new ArrayList<>();

    public ProcGen () {}

    public ProcName generate() {
        ProcName newVariable = new ProcName();
        this.existingProc.add(newVariable);
        return newVariable;
    }

    public ProcName getRandomExisting() {
        if (this.existingProc.size() <= 0) {
            return generate();
        }
        int upperLimit = this.existingProc.size();
        Random r = new Random();
        int randomIndex = r.nextInt(upperLimit);

        return this.existingProc.get(randomIndex);
    }

    public ProcName getRandom() {

        if (this.existingProc.size() <= 0) {
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
                int upperLimit = this.existingProc.size();
                int randomIndex = r.nextInt(upperLimit);

                return this.existingProc.get(randomIndex);
        }
    }
}
