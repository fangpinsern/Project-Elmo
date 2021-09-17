package com.company.base;

import java.util.ArrayList;
import java.util.Arrays;

public class TermVal {
    //    term ‘*’ factor | term ‘/’ factor | term ‘%’ factor | factor
    private String leftVal;
    private String rightVal;
    private String termOp;

    public TermVal(TermVal left, String termOp, Factor right) {
        this.leftVal = left.toString();
        this.rightVal = right.toString();
        this.termOp = termOp;
    }

    public TermVal(Factor left) {
        this.leftVal = left.toString();
    }

    public static ArrayList<String> getValidOps() {
        ArrayList<String> validOps = new ArrayList<>(Arrays.asList(
                "*",
                "/",
                "%"
        ));
        return validOps;
    }

    @Override
    public String toString() {
        if (termOp == null) {
            return leftVal;
        }
        return leftVal + termOp + rightVal;
    }
}
