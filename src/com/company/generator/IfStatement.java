package com.company.generator;

import com.company.base.CondExpr;

public class IfStatement implements Statement {
    private String condExpr;
    private StmtList ifStmt;
    private StmtList elseStmt;

    public IfStatement(CondExpr condExpr) {
        this.condExpr = condExpr.toString();
        this.ifStmt = new StmtList().generate(false);
        this.elseStmt = new StmtList().generate(false);
    }

    public void generateStatement() {
        return;
    }

    @Override
    public String toString() {
        return "if" + "(" +  this.condExpr + ")" +  "then" + " {\n" + this.ifStmt + "}" + "else" + "{\n" +  this.elseStmt + "}";
    }
}
