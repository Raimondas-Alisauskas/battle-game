package com.cb.bl.fight;

public class Attack {
    private int targetId;
    private Weapon weapon;
    private boolean isAttack;
    private boolean isWinned;



    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    public boolean isAttack() {
        return isAttack;
    }

    public void setAttack(boolean attack) {
        isAttack = attack;
    }

    public boolean isWinned() {
        return isWinned;
    }

    public void setWinned(boolean winned) {
        isWinned = winned;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
