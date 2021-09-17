package com.company.generator;

import com.company.base.CondExpr;
import com.company.base.ExprVal;
import com.company.base.Factor;
import com.company.base.TermVal;
import com.company.utils.CondExprGen;
import com.company.utils.ExprGen;
import com.company.utils.VarGen;

import java.util.ArrayList;

public class StmtList {
    //list of stmt - stmt interface
    private ArrayList<Statement> statementList = new ArrayList<Statement>();

    public StmtList generate(boolean isNesting) {
        VarGen variableList = new VarGen();
        ExprGen exprGen = new ExprGen();
        CondExprGen condExprGen = new CondExprGen();
        ExprVal test = exprGen.generate();
        if (isNesting) {
            Statement newStmt3 = new IfStatement(condExprGen.getRandom());
            newStmt3.generateStatement();
            this.statementList.add(newStmt3);
        }
        Statement newStmt = new ReadStatement("variable");
        newStmt.generateStatement();
        this.statementList.add(newStmt);
        Statement newStmt2 = new AssignStatement(variableList.generateVariable(), test);
        newStmt2.generateStatement();
        this.statementList.add(newStmt2);

        return this;
    }

    @Override
    public String toString() {
        String stringReturnStatment = "";
        for(int i = 0; i < statementList.size(); i++){
            stringReturnStatment = stringReturnStatment + statementList.get(i).toString() + "\n";
        }
        return stringReturnStatment;
//        return "StmtList{" +
//                "statementList=" + statementList +
//                '}';
    }
}
