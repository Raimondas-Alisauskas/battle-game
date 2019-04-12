package com.cb.bl;

import com.cb.bl.fight.Weapon;

import java.util.List;

public class FighterBL {
    private int id;
    private int rate;
    private int moneyLeft;
    private int honorLeft;
    private List<Weapon> weaponList;

    //Character
//    private String name;
//    private String party;
//    private Blob picture;


    public FighterBL(int id) {
        this.id = id;
    }

    public FighterBL(int id, int rate, int moneyLeft, int honorLeft, List<Weapon> weaponList) {
        this.id = id;
        this.rate = rate;
        this.moneyLeft = moneyLeft;
        this.honorLeft = honorLeft;
        this.weaponList = weaponList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getMoneyLeft() {
        return moneyLeft;
    }

    public void setMoneyLeft(int moneyLeft) {
        this.moneyLeft = moneyLeft;
    }

    public int getHonorLeft() {
        return honorLeft;
    }

    public void setHonorLeft(int honorLeft) {
        this.honorLeft = honorLeft;
    }

    public List<Weapon> getWeaponList() {
        return weaponList;
    }

    public void setWeaponList(List<Weapon> weaponList) {
        this.weaponList = weaponList;
    }
}
