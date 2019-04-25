package com.cb.dal;

public class FightCallsDAL {

    private int id;
    private int callingFighter;
    private int calledFighter;
    private boolean onFight;

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

}
