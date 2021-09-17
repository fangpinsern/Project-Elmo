package com.company.utils;

import com.company.base.ConstVal;

import java.util.ArrayList;
import java.util.Random;

public class ConstGen {
    public static ArrayList<ConstVal> existingConst = new ArrayList<>();

    public ConstGen () {}

    public ConstVal generateVariable() {
        ConstVal newConst = new ConstVal();
        this.existingConst.add(newConst);
        return newConst;
    }

    public ConstVal getRandomVariables() {
        if (this.existingConst.size() <= 0) {
            return generateVariable();
        }
        int upperLimit = this.existingConst.size();
        Random r = new Random();
        int randomIndex = r.nextInt(upperLimit);

        return this.existingConst.get(randomIndex);
    }
}
