package com.company.base;

public class RelFactor {
    //    var_name | const_value | expr
    private String val;

    public RelFactor(VarName name) {
        this.val = name.toString();
    }

    public RelFactor(ConstVal name) {
        this.val = name.toString();
    }

    public RelFactor(ExprVal name) {
        this.val = name.toString();
    }

    @Override
    public String toString() {
        return val;
    }
}
