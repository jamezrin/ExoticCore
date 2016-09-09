package me.jaime29010.work.exoticcore.utils;

import java.text.DecimalFormat;

public class NumberFormatter {
    private static String[] suffix = new String[]{"", "k", "m", "b", "t"};
    private static int MAX_LENGTH = 4;

    public static String format(double number) {
        String result = new DecimalFormat("##0E0").format(number);
        result = result.replaceAll("E[0-9]", suffix[Character.getNumericValue(result.charAt(result.length() - 1)) / 3]);
        while (result.length() > MAX_LENGTH || result.matches("[0-9]+\\.[a-z]")) {
            result = result.substring(0, result.length() - 2) + result.substring(result.length() - 1);
        }
        return result;
    }
}
