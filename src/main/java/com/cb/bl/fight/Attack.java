package com.cb.bl.fight;

import com.cb.constants.AttackType;

public class Attack {
    private int targetId;
    private Weapon weapon;
    private AttackType attackType;
    private boolean isWinned;


    public Attack(int targetId, Weapon weapon, AttackType attackType) {
        this.targetId = targetId;
        this.weapon = weapon;
        this.attackType = attackType;
    }

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    public AttackType getAttackType() {
        return attackType;
    }

    public void setAttackType(AttackType attackType) {
        this.attackType = attackType;
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
