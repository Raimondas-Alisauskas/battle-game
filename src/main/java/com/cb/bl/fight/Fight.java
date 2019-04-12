package com.cb.bl.fight;

import com.cb.bl.FighterBL;

public class Fight {
    private int fightId;
    private FighterBL fighter1;
    private FighterBL fighter2;
    private FightAction fighter1Action;
    private FightAction fighter2Action;
    private FightResult fightResult;

    public Fight() {
    }

    public Fight(FighterBL fighter1, FighterBL fighter2, FightAction fighter1Action, FightAction fighter2Action) {
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
        this.fighter1Action = fighter1Action;
        this.fighter2Action = fighter2Action;
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

    public FightAction getFighter1Action() {
        return fighter1Action;
    }

    public void setFighter1Action(FightAction fighter1Action) {
        this.fighter1Action = fighter1Action;
    }

    public FightAction getFighter2Action() {
        return fighter2Action;
    }

    public void setFighter2Action(FightAction fighter2Action) {
        this.fighter2Action = fighter2Action;
    }

    public FightResult getFightResult() {
        return fightResult;
    }

    public void setFightResult(FightResult fightResult) {
        this.fightResult = fightResult;
    }
}
