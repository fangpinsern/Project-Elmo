package com.company.base;

import java.util.Random;

public class Name {

    public static String randomGeneratedName(int length) {
        String validUpperLetter[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        String validLowerLetter[] = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String validNumbers[] = {"0","1","2","3","4","5","6","7","8","9","0"};

        int upperUpperLimit = validUpperLetter.length;
        int upperLowerLimit = validLowerLetter.length;
        int upperIntLimit = validUpperLetter.length;

        Random r = new Random();
        int randomIndex = r.nextInt(upperLowerLimit);
        String returnString = validLowerLetter[randomIndex];

        for (int i = 0; i < length; i++) {
            String[] choice;
            int randomChoiceIndex = r.nextInt(3);
            switch (randomChoiceIndex){
                case 0:
                    choice = validUpperLetter;
                    break;
                case 2:
                    choice = validNumbers;
                    break;
                default:
                    choice = validLowerLetter;
            }
            randomIndex = r.nextInt(choice.length);
            returnString = returnString + choice[randomIndex];
        }

        return returnString;
    }
}
