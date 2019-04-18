package com.cb.utils.fightUtils;

import com.cb.bl.fight.Weapon;
import com.cb.constants.AttackType;

public class ControllerUtility {

    public Weapon getWeaponFromAttribute(String string){
        String[] arr = string.split("--");
        return  new Weapon(arr[0],Integer.parseInt(arr[1]));
    }

    public AttackType getAttackTypeFromString (String string){
        switch (string){
            case "at":
                return AttackType.ATTACK;
            case "def":
                return AttackType.DEFENCE;
            default:
                return AttackType.NEUTRAL;
        }
    }


}
