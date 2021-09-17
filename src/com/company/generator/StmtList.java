package com.company.generator;

import java.util.ArrayList;

public class StmtList {
    //list of stmt - stmt interface
    private ArrayList<Statement> statementList = new ArrayList<Statement>();

    public void generate() {
        Statement newStmt = new ReadStatement("variable");
        newStmt.generateStatement();
        this.statementList.add(newStmt);
        Statement newStmt2 = new AssignStatement("x", "y+z");
        newStmt2.generateStatement();
        this.statementList.add(newStmt2);
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
