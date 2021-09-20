package com.company.generator;

import com.company.base.ProcName;
import com.company.utils.CLIInput;

import java.util.ArrayList;

public class Procedure {
    public String procedureName;
    public StmtList statementList;
    private int nestingLevel = 1;
    private int seedValue = 10;

    public Procedure(ProcName procedureName) {
        this.procedureName = procedureName.toString();
    }

    public void generate(int nestingLevel, int seedValue, boolean randomiseNoOfLines) {
        this.statementList = new StmtList();
        int usedNestingLevel = nestingLevel;
        int usedSeedValue = seedValue;
        if (nestingLevel <= -1) {
            usedNestingLevel = this.nestingLevel;
        }
        if (seedValue < 0) {
            usedSeedValue = this.seedValue;
        }
        this.statementList.generate(CLIInput.nestingLevel, CLIInput.seedValue, CLIInput.randomiseNoOfLines);
        return;
    }

    public ArrayList<Statement> getStatmentList() {
        return this.statementList.getStatementList();
    }

    @Override
    public String toString() {
        return "procedure "+ this.procedureName + "{" + this.statementList.toString() + "}";
    }
}
