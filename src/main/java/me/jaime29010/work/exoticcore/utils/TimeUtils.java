package me.jaime29010.work.exoticcore.utils;

public class TimeUtils {
    public static String convert(long seconds) {
        long sec = seconds % 60;
        long minutes = seconds % 3600 / 60;
        long hours = seconds % 86400 / 3600;
        long days = seconds / 86400;
        return format((int) days) + ":" + format((int) hours) + ":" + format((int) minutes) + ":" + format((int) sec);
    }

    private static String format(int number) {
        if (number >= 0 && number <= 9) {
            return "0" + number;
        }
        return "" + number;
    }
}
