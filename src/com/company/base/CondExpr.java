package com.company.base;

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

    @Override
    public String toString() {
        return this.val;
    }
}
