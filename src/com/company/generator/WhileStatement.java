package com.company.generator;

import com.company.baseGenerator.CondExprGen;

public class WhileStatement implements Statement {
//    while: ‘while’ ‘(’ cond_expr ‘)’ ‘{‘ stmtLst ‘}’
    private String condExpr;
    private StmtList whileStmt;
    private int nested = 0;
    private String name = "While";

//    public WhileStatement(CondExpr condExpr) {
//        this.condExpr = condExpr.toString();
//        this.whileStmt = new StmtList().generate(0);
//    }

    public WhileStatement (int whileNested) {
        this.nested = whileNested;
    }

    public void generateStatement() {
        CondExprGen condExprGen = new CondExprGen();
        this.condExpr = condExprGen.getRandom().toString();
        this.whileStmt = new StmtList().generate(this.nested, -1,true);
        return;
    }

    public String infoString() {
        return String.format("%s - %s", this.name, this.condExpr);
    }

    @Override
    public String toString() {
        return "while" + " ( " +  this.condExpr + " ) " +  "{" + this.whileStmt + "}";
    }
}
