package me.jaime29010.work.exoticcore.data;

public final class JsonPlayer {
    private int level, points;

    public JsonPlayer(int level, int points) {
        this.level = level;
        this.points = points;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
