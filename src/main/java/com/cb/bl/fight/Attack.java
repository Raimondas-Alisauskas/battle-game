package com.cb.bl.fight;

import com.cb.constants.AttackState;

public class Attack {
    private int targetId;
    private Weapon weapon;
    private AttackState attackState;
    private boolean isWinned;


    public Attack(int targetId, Weapon weapon, AttackState attackState) {
        this.targetId = targetId;
        this.weapon = weapon;
        this.attackState = attackState;
    }

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    public AttackState getAttackState() {
        return attackState;
    }

    public void setAttackState(AttackState attackState) {
        this.attackState = attackState;
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
