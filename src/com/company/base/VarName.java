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
        return "johndoe";
    }

    @Override
    public String toString() {
        return this.name;
    }
}
