package com.company.base;

import java.util.ArrayList;
import java.util.Arrays;

public class CondExpr {
    //    rel_expr | ‘!’ ‘(’ cond_expr ‘)’ | ‘(’ cond_expr ‘)’ ‘&&’ ‘(’ cond_expr ‘)’ |
//    ‘(’ cond_expr ‘)’ ‘||’ ‘(’ cond_expr ‘)’
    private String val;

    public CondExpr(RelExpr val) {
        this.val = val.toString();
    }

    public CondExpr(CondExpr val) {
        this.val = "! ( " + val.toString() + " )";
    }

    public CondExpr(CondExpr left, String Op, CondExpr right) {
        this.val = "( " + left.toString() + " ) " + Op + " ( " + right + " )";
    }

    public static ArrayList<String> getValidOps() {
        ArrayList<String> validOps = new ArrayList<>(Arrays.asList(
                "&&",
                "||"
        ));
        return validOps;
    }

    @Override
    public String toString() {
        return this.val;
    }
}
