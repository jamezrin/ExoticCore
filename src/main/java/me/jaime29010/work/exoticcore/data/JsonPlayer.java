package me.jaime29010.work.exoticcore.data;

public final class JsonPlayer {
    private int level, points, bounty;

    public JsonPlayer(int level, int points) {
        this.level = level;
        this.points = points;
        this.bounty = 0;
    }

    public JsonPlayer(int level, int points, int bounty) {
        this.level = level;
        this.points = points;
        this.bounty = bounty;
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

    public int getBounty() {
        return bounty;
    }

    public void setBounty(int bounty) {
        this.bounty = bounty;
    }
}
