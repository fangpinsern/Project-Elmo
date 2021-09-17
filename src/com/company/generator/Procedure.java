package com.company.generator;

import java.util.ArrayList;

public class Procedure {
    public String procedureName;
    public StmtList statementList;

    public Procedure(String procedureName) {
        this.procedureName = procedureName;
    }

    public void generate() {
        this.statementList = new StmtList();
        this.statementList.generate(true);
        return;
    }

    @Override
    public String toString() {
        return "procedure "+ this.procedureName + "{\n" + this.statementList.toString() + "}";
    }
}
