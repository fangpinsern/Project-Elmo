package com.company.generator;

import com.company.base.ProcName;

import java.util.ArrayList;

public class Procedure {
    public String procedureName;
    public StmtList statementList;

    public Procedure(ProcName procedureName) {
        this.procedureName = procedureName.toString();
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
