package com.cb.bl.fight;

import java.util.List;

public class FightAction {
    private int fightActionNo;
    private List<Attack> attackList;
    private int noOfWinnings;


    public FightAction(int fightActionNo, List<Attack> attackList) {
        this.fightActionNo = fightActionNo;
        this.attackList = attackList;
    }

    public int getFightActionNo() {
        return fightActionNo;
    }

    public void setFightActionNo(int fightActionNo) {
        this.fightActionNo = fightActionNo;
    }

    public List<Attack> getAttackList() {
        return attackList;
    }

    public void setAttackList(List<Attack> attackList) {
        this.attackList = attackList;
    }

    public int getNoOfWinnings() {
        return noOfWinnings;
    }

    public void setNoOfWinnings(int noOfWinnings) {
        this.noOfWinnings = noOfWinnings;
    }
}
