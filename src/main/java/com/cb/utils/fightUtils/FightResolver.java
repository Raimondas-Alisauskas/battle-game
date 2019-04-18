package com.cb.utils.fightUtils;

import com.cb.bl.fight.Attack;
import com.cb.bl.fight.FighterAction;
import com.cb.bl.fight.FightActionsResult;
import com.cb.constants.AttackType;


public class FightResolver {

    public int getAttackWinner(Attack attack1, Attack attack2){
        int attackWinnerNo = -1;
        if(attack1.getTargetId() == attack2.getTargetId()){

            if(attack1.getAttackType() == AttackType.ATTACK && attack2.getAttackType() == AttackType.ATTACK
                || attack1.getAttackType() == AttackType.DEFENCE && attack2.getAttackType() == AttackType.DEFENCE){
                attackWinnerNo = getBiggerPowerNo(attack1.getWeapon().getPower(),attack2.getWeapon().getPower());
            }else if (attack1.getAttackType() == AttackType.NEUTRAL && attack2.getAttackType() == AttackType.NEUTRAL
                    || attack1.getAttackType() == AttackType.DEFENCE && attack2.getAttackType() == AttackType.ATTACK
                    || attack1.getAttackType() == AttackType.ATTACK && attack2.getAttackType() == AttackType.DEFENCE){
                attackWinnerNo = 0;
            }else if(attack1.getAttackType() == AttackType.NEUTRAL && attack2.getAttackType() != AttackType.NEUTRAL){
                attackWinnerNo = 2;
            }else if (attack1.getAttackType() != AttackType.NEUTRAL && attack2.getAttackType() == AttackType.NEUTRAL) {
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

    public FightActionsResult getFightActionResult(FighterAction fighterAction1, FighterAction fighterAction2){
        FightActionsResult fightActionsResult = new FightActionsResult();

        int noOfWinnings1 = 0;
        int noOfWinnings2 = 0;

        for (int i = 0; i < fighterAction1.getAttackList().size(); i++) {
            int attack1Winner = getAttackWinner(fighterAction1.getAttackList().get(i), fighterAction2.getAttackList().get(i));
            if(attack1Winner == 1){
                noOfWinnings1 ++ ;
            } else if(attack1Winner == 2){
                noOfWinnings2 ++ ;
            }
        }

        fighterAction1.setNoOfWinnings(noOfWinnings1);
        fighterAction2.setNoOfWinnings(noOfWinnings2);

        fightActionsResult.setFighter1Action(fighterAction1);
        fightActionsResult.setFighter2Action(fighterAction2);
        return fightActionsResult;
    }



}
