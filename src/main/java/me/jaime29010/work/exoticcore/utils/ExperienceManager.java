package me.jaime29010.work.exoticcore.utils;

import org.bukkit.entity.Player;

import java.math.BigDecimal;

public class ExperienceManager {
    public static int getTotalExperience(Player player) {
        int level = player.getLevel();
        if (level >= 0 && level <= 15) {
            int a = (int) Math.ceil(Math.pow(level, 2) + (6 * level));
            int b = 2 * level + 7;
            double c = Double.parseDouble(Float.toString(player.getExp()));
            a += Math.ceil(c * b);
            return a;
        } else if (level > 15 && level <= 30) {
            int a = (int) Math.ceil((2.5 * Math.pow(level, 2) - (40.5 * level) + 360));
            int b = 5 * level - 38;
            double c = Double.parseDouble(Float.toString(player.getExp()));
            a += Math.ceil(c * b);
            return a;
        } else {
            int a = (int) Math.ceil(((4.5 * Math.pow(level, 2) - (162.5 * level) + 2220)));
            int b = 9 * level - 158;
            double c = Double.parseDouble(Float.toString(player.getExp()));
            a += Math.ceil(c * b);
            return a;
        }
    }

    public static void setTotalExperience(Player player, int xp) {
        if (xp >= 0 && xp < 351) {
            int a = 1;
            int b = 6;
            int c = -xp;
            int d = (int) (-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
            int e = (int) (Math.pow(d, 2) + (6 * d));
            int f = xp - e;
            int g = (2 * d) + 7;
            float h = (float) f / (float) g;
            h = round(h, 2);

            player.setLevel(d);
            player.setExp(h);
        } else if (xp >= 352 && xp < 1507) {
            double a = 2.5;
            double b = -40.5;
            int c = -xp + 360;
            double d = (-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
            int e = (int) Math.floor(d);
            int f = (int) (2.5 * Math.pow(e, 2) - (40.5 * e) + 360);
            int g = xp - f;
            int h = (5 * e) - 38;
            float i = (float) g / (float) h;
            i = round(i, 2);

            player.setLevel(e);
            player.setExp(i);
        } else {
            double a = 4.5;
            double b = -162.5;
            int c = -xp + 2220;
            double d = (-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
            int e = (int) Math.floor(d);
            int f = (int) (4.5 * Math.pow(e, 2) - (162.5 * e) + 2220);
            int g = xp - f;
            int h = (9 * e) - 158;
            float i = (float) g / (float) h;
            i = round(i, 2);

            player.setLevel(e);
            player.setExp(i);
        }
    }

    private static float round(float value, int scale) {
        BigDecimal decimal = new BigDecimal(Float.toString(value));
        decimal = decimal.setScale(scale, BigDecimal.ROUND_HALF_DOWN);
        return decimal.floatValue();
    }
}