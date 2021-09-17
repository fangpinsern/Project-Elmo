package com.company.base;

public class VarName {
    private String name;


    public VarName(String name) {
        this.name = name;
    }

    public VarName() {
        this.name = randomGeneratedName();
    }

    private String randomGeneratedName() {
        return Name.randomGeneratedName(10);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
