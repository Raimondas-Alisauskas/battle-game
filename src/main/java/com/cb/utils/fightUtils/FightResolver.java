package com.cb.utils.fightUtils;

import com.cb.bl.fight.Attack;
import com.cb.bl.fight.Fight;
import com.cb.bl.fight.FightResult;
import com.cb.constants.AttackState;


public class FightResolver {

    public int getAttackWinner(Attack attack1, Attack attack2){
        int attackWinnerNo = -1;
        if(attack1.getTargetId() == attack2.getTargetId()){

            if(attack1.getAttackState() == AttackState.ATTACK && attack2.getAttackState() == AttackState.ATTACK
                || attack1.getAttackState() == AttackState.DEFENCE && attack2.getAttackState() == AttackState.DEFENCE){
                attackWinnerNo = getBiggerPowerNo(attack1.getWeapon().getPower(),attack2.getWeapon().getPower());
            }else if (attack1.getAttackState() == AttackState.NEUTRAL && attack2.getAttackState() == AttackState.NEUTRAL
                    || attack1.getAttackState() == AttackState.DEFENCE && attack2.getAttackState() == AttackState.ATTACK
                    || attack1.getAttackState() == AttackState.ATTACK && attack2.getAttackState() == AttackState.DEFENCE){
                attackWinnerNo = 0;
            }else if(attack1.getAttackState() == AttackState.NEUTRAL && attack2.getAttackState() != AttackState.NEUTRAL){
                attackWinnerNo = 2;
            }else if (attack1.getAttackState() != AttackState.NEUTRAL && attack2.getAttackState() == AttackState.NEUTRAL) {
                attackWinnerNo = 1;
            }
        }
        return attackWinnerNo;
    }

    private int getBiggerPowerNo (int power1, int power2){
        if (power1 == power2){
            return 0;
        }else if(power1 > power2){
            return  1;
        }return  2;
    }

    public FightResult getFightResult (Fight fight){
        FightResult fightResult = new FightResult();
        int fighter1Score = 0;
        int fighter2Score = 0;

        int attack1Winner = getAttackWinner(fight.getFighter1Action().getAttack1(), fight.getFighter2Action().getAttack1());
        fightResult.setAttack1WinnerNo(attack1Winner);

        if(attack1Winner ==1){
            fightResult.setFighter1Score(fighter1Score +1);
        } else if(attack1Winner ==2){fightResult.setFighter2Score(fighter2Score +1);}

        return fightResult;
    }



}
