package com.cb.bl.fight;

import java.util.List;

public class FightActionsResult {
    private FightAction fighter1Action;
    private FightAction fighter2Action;

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
}
