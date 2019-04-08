package com.cb.bl.fight;

public class FightResult {
    private int attack1WinnerId;
//    private int attack2WinnerId;
//    private int attack3WinnerId;
//    private int attack4WinnerId;
    private int fightWinnerId;
    private int winnerScore;
    private int loserScore;

    public int getAttack1WinnerId() {
        return attack1WinnerId;
    }

    public void setAttack1WinnerId(int attack1WinnerId) {
        this.attack1WinnerId = attack1WinnerId;
    }

    public int getFightWinnerId() {
        return fightWinnerId;
    }

    public void setFightWinnerId(int fightWinnerId) {
        this.fightWinnerId = fightWinnerId;
    }

    public int getWinnerScore() {
        return winnerScore;
    }

    public void setWinnerScore(int winnerScore) {
        this.winnerScore = winnerScore;
    }

    public int getLoserScore() {
        return loserScore;
    }

    public void setLoserScore(int loserScore) {
        this.loserScore = loserScore;
    }
}
