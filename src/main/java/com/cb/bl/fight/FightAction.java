package com.cb.bl.fight;

public class FightAction {
    private int fighterId;
    private Attack attack1;
//    private Attack attackBL2;
//    private Attack attackBL3;
//    private Attack attackBL4;
    private boolean isWinned;

    public FightAction(int fighterId, Attack attack1) {
        this.fighterId = fighterId;
        this.attack1 = attack1;
    }

    public int getFighterId() {
        return fighterId;
    }

    public void setFighterId(int fighterId) {
        this.fighterId = fighterId;
    }

    public Attack getAttack1() {
        return attack1;
    }

    public void setAttack1(Attack attack1) {
        this.attack1 = attack1;
    }


    public boolean isWinned() {
        return isWinned;
    }

    public void setWinned(boolean winned) {
        isWinned = winned;
    }
}
