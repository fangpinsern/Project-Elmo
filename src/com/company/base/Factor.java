package com.company.base;

public class Factor {
    private String val;

    public Factor(VarName name) {
        this.val = name.toString();
    }

    public Factor(ConstVal val) {
        this.val = val.toString();
    }

    public Factor(ExprVal val) {
        this.val = "(" + val.toString() + ")";
    }

    @Override
    public String toString() {
        return this.val;
    }
}
