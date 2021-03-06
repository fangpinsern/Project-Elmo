package com.company.generator;

import com.company.baseGenerator.CondExprGen;

public class IfStatement implements Statement {
    private String condExpr;
    private int ifNested = 0;
    private int elseNested = 0;
    private StmtList ifStmt;
    private StmtList elseStmt;
    private String name = "If";

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
        this.ifStmt = new StmtList().generate(this.ifNested, -1, false);
        this.elseStmt = new StmtList().generate(this.elseNested, -1, false);
        return;
    }

    public String infoString() {
        return String.format("%s - %s", this.name, this.condExpr);
    }

    @Override
    public String toString() {
        return "if" + "(" +  this.condExpr + ")" +  "then" + " {" + this.ifStmt + "}" + "else" + "{" +  this.elseStmt + "}";
    }
}
