package com.company.base;

public class ProcName {
    private String name;

    public ProcName(String name) {
        this.name = name;
    }

    public ProcName() {
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
