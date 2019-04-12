package com.cb.bl.fight;

import com.cb.bl.FighterBL;

import java.util.List;

public class Fight {
    private int fightId;
    private FighterBL fighter1;
    private FighterBL fighter2;
    private List<FightAction> fighter1ActionList;
    private List<FightAction> fighter2ActionList;


    public Fight() {
    }

    public Fight(FighterBL fighter1, FighterBL fighter2) {
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
    }

    public int getFightId() {
        return fightId;
    }

    public void setFightId(int fightId) {
        this.fightId = fightId;
    }

    public FighterBL getFighter1() {
        return fighter1;
    }

    public void setFighter1(FighterBL fighter1) {
        this.fighter1 = fighter1;
    }

    public FighterBL getFighter2() {
        return fighter2;
    }

    public void setFighter2(FighterBL fighter2) {
        this.fighter2 = fighter2;
    }

    public List<FightAction> getFighter1ActionList() {
        return fighter1ActionList;
    }

    public void setFighter1ActionList(List<FightAction> fighter1ActionList) {
        this.fighter1ActionList = fighter1ActionList;
    }

    public List<FightAction> getFighter2ActionList() {
        return fighter2ActionList;
    }

    public void setFighter2ActionList(List<FightAction> fighter2ActionList) {
        this.fighter2ActionList = fighter2ActionList;
    }
}
