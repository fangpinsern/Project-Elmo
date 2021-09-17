package com.company.utils;

import com.company.base.ProcName;
import com.company.base.VarName;

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

    public ProcName getRandomProc() {
        if (this.existingProc.size() <= 0) {
            return generate();
        }
        int upperLimit = this.existingProc.size();
        Random r = new Random();
        int randomIndex = r.nextInt(upperLimit);

        return this.existingProc.get(randomIndex);
    }
}
