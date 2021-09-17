package com.company.base;

import java.util.Arrays;
import java.util.Random;

public class ProcName {
    private String name;

    private String validUpperLetter[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    private String validLowerLetter[] = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    private String validNumbers[] = {"0","1","2","3","4","5","6","7","8","9","0"};

    public ProcName(String name) {
        this.name = name;
    }

    public ProcName() {
        this.name = Name.randomGeneratedName(10);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
