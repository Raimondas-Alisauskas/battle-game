package com.cb.bl.fight;

public class Fight {
    private int fightId;
    private int fighter1Id;
    private int fighter2Id;
    private FightAction fighter1Action;
    private FightAction fighter2Action;
    private FightResult fightResult;

    public int getFightId() {
        return fightId;
    }

    public void setFightId(int fightId) {
        this.fightId = fightId;
    }

    public int getFighter1Id() {
        return fighter1Id;
    }

    public void setFighter1Id(int fighter1Id) {
        this.fighter1Id = fighter1Id;
    }

    public int getFighter2Id() {
        return fighter2Id;
    }

    public void setFighter2Id(int fighter2Id) {
        this.fighter2Id = fighter2Id;
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
