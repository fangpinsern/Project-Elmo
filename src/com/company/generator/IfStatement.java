package com.company.generator;

import com.company.base.CondExpr;
import com.company.utils.CondExprGen;

public class IfStatement implements Statement {
    private String condExpr;
    private int ifNested = 0;
    private int elseNested = 0;
    private StmtList ifStmt;
    private StmtList elseStmt;

//    public IfStatement(CondExpr condExpr) {
//        this.condExpr = condExpr.toString();
//        this.ifStmt = new StmtList().generate(false);
//        this.elseStmt = new StmtList().generate(false);
//    }

    public IfStatement (int ifNestLevel, int elseNestLevel) {
        this.ifNested = ifNestLevel;
        this.elseNested = elseNestLevel;
    }

    public void generateStatement() {
        CondExprGen condExprGen = new CondExprGen();
        this.condExpr = condExprGen.getRandom().toString();
        this.ifStmt = new StmtList().generate(this.ifNested);
        this.elseStmt = new StmtList().generate(this.elseNested);
        return;
    }

    @Override
    public String toString() {
        return "if" + "(" +  this.condExpr + ")" +  "then" + " {\n" + this.ifStmt + "}" + "else" + "{\n" +  this.elseStmt + "}";
    }
}
