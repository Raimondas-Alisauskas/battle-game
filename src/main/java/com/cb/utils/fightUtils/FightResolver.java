package com.cb.utils.fightUtils;

import com.cb.bl.FighterBL;
import com.cb.bl.fight.Attack;
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



}
