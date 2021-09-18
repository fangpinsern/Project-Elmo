package com.company.utils;

import com.company.base.ConstVal;
import com.company.base.ExprVal;

import java.util.ArrayList;
import java.util.Random;

public class ConstGen {
    public static ArrayList<ConstVal> existingConst = new ArrayList<>();

    public ConstGen () {}

    public ConstVal generate() {
        ConstVal newConst = new ConstVal();
        this.existingConst.add(newConst);
        return newConst;
    }

    public ConstVal getRandomExisting() {
        if (this.existingConst.size() <= 0) {
            return generate();
        }
        int upperLimit = this.existingConst.size();
        Random r = new Random();
        int randomIndex = r.nextInt(upperLimit);

        return this.existingConst.get(randomIndex);
    }

    public ConstVal getRandom() {

        if (this.existingConst.size() <= 0) {
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
                int upperLimit = this.existingConst.size();
                int randomIndex = r.nextInt(upperLimit);

                return this.existingConst.get(randomIndex);
        }
    }
}
