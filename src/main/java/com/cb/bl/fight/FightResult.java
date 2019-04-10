package com.cb.bl.fight;

public class FightResult {
    private int attack1WinnerNo;
//    private int attack2WinnerNo;
//    private int attack3WinnerNo;
//    private int attack4WinnerNo;
    private int fighter1Score;
    private int fighter2Score;



    public int getAttack1WinnerNo() {
        return attack1WinnerNo;
    }

    public void setAttack1WinnerNo(int attack1WinnerNo) {
        this.attack1WinnerNo = attack1WinnerNo;
    }

//    public int getFightWinnerId() {
//        return fightWinnerId;
//    }
//
//    public void setFightWinnerId(int fightWinnerId) {
//        this.fightWinnerId = fightWinnerId;
//    }

    public int getFighter1Score() {
        return fighter1Score;
    }

    public void setFighter1Score(int fighter1Score) {
        this.fighter1Score = fighter1Score;
    }

    public int getFighter2Score() {
        return fighter2Score;
    }

    public void setFighter2Score(int fighter2Score) {
        this.fighter2Score = fighter2Score;
    }
}
