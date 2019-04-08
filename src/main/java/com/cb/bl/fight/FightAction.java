package com.cb.bl.fight;

public class FightAction {
    private int id;
    private Attack attack1;
//    private Attack attackBL2;
//    private Attack attackBL3;
//    private Attack attackBL4;
    private boolean isWinned;

    public FightAction(int id, Attack attack1) {
        this.id = id;
        this.attack1 = attack1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
