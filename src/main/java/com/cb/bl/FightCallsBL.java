package com.cb.bl;

public class FightCallsBL {

    private int id;
    private int callingFighter;
    private int calledFighter;
    private boolean onFight;
    private String action;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCallingFighter() {
        return callingFighter;
    }

    public void setCallingFighter(int callingFighter) {
        this.callingFighter = callingFighter;
    }

    public int getCalledFighter() {
        return calledFighter;
    }

    public void setCalledFighter(int calledFighter) {
        this.calledFighter = calledFighter;
    }

    public boolean isOnFight() {
        return onFight;
    }

    public void setOnFight(boolean onFight) {
        this.onFight = onFight;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
