package com.company.generator;

import com.company.base.CondExpr;

public class WhileStatement implements Statement {
//    while: ‘while’ ‘(’ cond_expr ‘)’ ‘{‘ stmtLst ‘}’
    private String condExpr;
    private StmtList whileStmt;

    public WhileStatement(CondExpr condExpr) {
        this.condExpr = condExpr.toString();
        this.whileStmt = new StmtList().generate(false);
    }

    public void generateStatement() {
        return;
    }

    @Override
    public String toString() {
        return "while" + " ( " +  this.condExpr + " ) " +  "{\n" + this.whileStmt + "}";
    }
}
