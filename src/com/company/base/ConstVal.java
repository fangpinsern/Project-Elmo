package com.company.base;

import java.util.Random;

public class ConstVal {
    private int val;

    public ConstVal(int val) {
        this.val = val;
    }

    public ConstVal() {
        Random r = new Random();
        this.val = r.nextInt();
    }

    @Override
    public String toString() {
        return this.val + "";
    }
}
