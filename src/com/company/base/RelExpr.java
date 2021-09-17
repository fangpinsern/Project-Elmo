package com.company.base;

import java.util.ArrayList;
import java.util.Arrays;

public class RelExpr {
    //    rel_factor ‘>’ rel_factor | rel_factor ‘>=’ rel_factor | rel_factor ‘<’ rel_factor |
//    rel_factor ‘<=’ rel_factor | rel_factor ‘==’ rel_factor | rel_factor ‘!=’ rel_factor
    private String left;
    private String right;
    private String op;

    public RelExpr(RelFactor left, String op, RelFactor right) {
        this.left = left.toString();
        this.right = right.toString();
        this.op = op;
    }

    public static ArrayList<String> getValidOps() {
        ArrayList<String> validOps = new ArrayList<>(Arrays.asList(
                ">",
                ">=",
                "<",
                "<=",
                "==",
                "!="
        ));
        return validOps;
    }

    @Override
    public String toString() {
        return this.left + " " + this.op + " " + this.right;
    }
}
