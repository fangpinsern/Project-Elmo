package com.company.generator;

public interface Statement {
    public void generateStatement();

    public String infoString();

    @Override
    public String toString();
}
