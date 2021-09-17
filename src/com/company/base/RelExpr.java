package com.company.base;

import java.util.ArrayList;
import java.util.Arrays;

public class RelExpr {
    //    rel_factor ‘>’ rel_factor | rel_factor ‘>=’ rel_factor | rel_factor ‘<’ rel_factor |
//    rel_factor ‘<=’ rel_factor | rel_factor ‘==’ rel_factor | rel_factor ‘!=’ rel_factor
    private String left;
    private String right;
    private String op;

    private ArrayList<String> validOps = new ArrayList<>(Arrays.asList(
            ">",
            ">=",
            "<",
            "<=",
            "==",
            "!="
    ));

    public RelExpr(RelFactor left, String op, RelFactor right) {
        this.left = left.toString();
        this.right = right.toString();
        this.op = op;
    }

    public ArrayList<String> getValidOps() {
        return this.validOps;
    }

    @Override
    public String toString() {
        return this.left + " " + this.op + " " + this.right;
    }
}
