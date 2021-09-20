package com.company.generator;

import com.company.baseGenerator.CondExprGen;
import com.company.baseGenerator.ExprGen;
import com.company.baseGenerator.VarGen;

import java.util.ArrayList;
import java.util.Random;

public class StmtList {
    //list of stmt - stmt interface
    private ArrayList<Statement> statementList = new ArrayList<Statement>();
    private int nestedLevel = 0;

    private String nestedStatement[] = {"ReadStatement", "PrintStatement", "WhileStatement", "IfStatement", "AssignStatement"};
    private String nonNestedStatement[] = {"ReadStatement", "PrintStatement", "AssignStatement"};

    public StmtList(int nestedLevel) {
        this.nestedLevel = nestedLevel;
    }

    public StmtList() {

    }

//    public StmtList generate(int nestedLevel, int numberOfStatements) {
//        // nested - read | print | call | while | if | assign
//        // non nested - read | print | call | assign
//
//        VarGen varGen = new VarGen();
//        ExprGen exprGen = new ExprGen();
//        CondExprGen condExprGen = new CondExprGen();
//
//        if (nestedLevel <= 0) {
//            Statement newStmt3 = new IfStatement(this.nestedLevel, this.nestedLevel);
//            newStmt3.generateStatement();
//            this.statementList.add(newStmt3);
//            Statement newStmt4 = new WhileStatement(condExprGen.getRandom());
//            newStmt4.generateStatement();
//            this.statementList.add(newStmt4);
//            Statement newStmt = new ReadStatement(varGen.getRandomExisting());
//            newStmt.generateStatement();
//            this.statementList.add(newStmt);
//        }
//        Statement newStmt2 = new AssignStatement(varGen.getRandom(), exprGen.getRandom());
//        newStmt2.generateStatement();
//        this.statementList.add(newStmt2);
//        Statement newStmt5 = new PrintStatement(varGen.getRandomExisting());
//        newStmt5.generateStatement();
//        this.statementList.add(newStmt5);
//
//        return this;
//    }

    public StmtList generate(int nestedLevel, int seed, boolean randomiseLines) {
        this.nestedLevel = nestedLevel;
        int stmtSeed = seed;
        boolean genRandomLines = randomiseLines;
        if (stmtSeed <= -1) {
            stmtSeed = 10;
            genRandomLines = true;
        }
        int randomNoLines = seed;
        Random r = new Random();

        if (genRandomLines) {
            randomNoLines = r.nextInt(stmtSeed);
        }

        VarGen varGen = new VarGen();
        ExprGen exprGen = new ExprGen();
        CondExprGen condExprGen = new CondExprGen();

        if (nestedLevel > 0) {
            reduceNestLevel();
            for (int i = 0; i < randomNoLines; i++){
                int choice = r.nextInt(this.nestedStatement.length);
                Statement choiceStatement = statementSwitch(this.nestedStatement[choice]);
                choiceStatement.generateStatement();
                this.statementList.add(choiceStatement);
            }
        } else {
            for (int i = 0; i < randomNoLines; i++){
                int choice = r.nextInt(this.nonNestedStatement.length);
                Statement choiceStatement = statementSwitch(this.nonNestedStatement[choice]);
                choiceStatement.generateStatement();
                this.statementList.add(choiceStatement);
            }
        }

        return this;
    }

    private void reduceNestLevel() {
        this.nestedLevel = this.nestedLevel - 1;
    }

    private Statement statementSwitch(String statementName) {
//        {"ReadStatement", "PrintStatement", "WhileStatement", "IfStatement", "AssignStatement"}
        switch (statementName){
            case "ReadStatement":
                return new ReadStatement();
            case "PrintStatement":
                return new PrintStatement();
            case "WhileStatement":
                return new WhileStatement(this.nestedLevel);
            case "IfStatement":
                return new IfStatement(this.nestedLevel, this.nestedLevel);
            default:
                return new AssignStatement();
        }
    }

    public ArrayList<Statement> getStatementList(){
        return this.statementList;
    }

    @Override
    public String toString() {
        String stringReturnStatment = "";
        for(int i = 0; i < statementList.size(); i++){
            stringReturnStatment = stringReturnStatment + statementList.get(i).toString();
        }
        return stringReturnStatment;
//        return "StmtList{" +
//                "statementList=" + statementList +
//                '}';
    }
}
