package com.company.utils;

public class Formatter {
    // loop through the character
    // if see {, add a newline and tab
    // if see ;, add newline
    // if see }, reduce tab

    public static String formatSIMPLE(String prog) {
        String out = "";
        String tabChar = "\t";
        String newlineChar = "\n";

        int tabsCount = 0;

        for (int i = 0; i < prog.length(); i++) {
            String character = Character.toString(prog.charAt(i));
            out = out + character;

            if (character.equals(";")) {
                String tabLevel = tabChar.repeat(tabsCount);
                out = out + newlineChar + tabLevel;
            } else if (character.equals("{")) {
                tabsCount = tabsCount + 1;
                String tabLevel = tabChar.repeat(tabsCount);
                out = out + "\n" + tabLevel;
            } else if (character.equals("}")) {
                tabsCount = tabsCount - 1;
                String tabLevel = tabChar.repeat(tabsCount);
                out = out + "\n" + tabLevel;
            }
        }

        return out;
    }

    private static String charDuplicator(int number){
        return "";
    }
}
