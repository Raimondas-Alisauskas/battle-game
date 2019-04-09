package com.cb.utils.fightUtils;

import com.cb.bl.FighterBL;
import com.cb.bl.fight.Attack;
import com.cb.bl.fight.FightAction;
import com.cb.bl.fight.Weapon;
import com.cb.constants.AttackState;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FightResolverTest {


    private FighterBL fighter1;
    private FighterBL fighter2;
    private FightAction fightAction1;
    private FightAction fightAction2;
    private Attack attack1a;
    private Attack attack2a;
    private Attack attack1d;
    private Attack attack2d;
    private Attack attack1n;
    private Attack attack2n;


    public void testFightersInitialisation() {
        Weapon weapon1 = new Weapon("1", 1);
        Weapon weapon2 = new Weapon("2", 2);

        attack1a = new Attack(1, weapon1, AttackState.ATTACK);
        attack2a = new Attack(1, weapon2, AttackState.ATTACK);
        attack1d = new Attack(1, weapon1, AttackState.DEFENCE);
        attack2d = new Attack(1, weapon2, AttackState.DEFENCE);
        attack1n = new Attack(1, weapon1, AttackState.NEUTRAL);
        attack2n = new Attack(1, weapon2, AttackState.NEUTRAL);


        List<Weapon> weaponList1 = new ArrayList<>();
        weaponList1.add(weapon1);
        weaponList1.add(weapon2);

        List<Weapon> weaponList2 = new ArrayList<>();
        weaponList2.add(weapon1);
        weaponList2.add(weapon2);

        fighter1 = new FighterBL(1, 100, 100, 100, weaponList1);
        fighter2 = new FighterBL(2, 100, 100, 100, weaponList2);

        fightAction1 = new FightAction(1, attack1d);
        fightAction2 = new FightAction(2, attack2d);

    }

    @Test
    public void getAttackWinnerTest() {
       testFightersInitialisation();
       FightResolver fightResolver = new FightResolver();

       Assert.assertEquals(2, fightResolver.getAttackWinner(attack1a, attack2a));
       Assert.assertEquals(2, fightResolver.getAttackWinner(attack1d, attack2d));
       Assert.assertEquals(0, fightResolver.getAttackWinner(attack1n, attack2n));
       Assert.assertEquals(0, fightResolver.getAttackWinner(attack1a, attack2d));
       Assert.assertEquals(1, fightResolver.getAttackWinner(attack1a, attack2n));
       Assert.assertEquals(1, fightResolver.getAttackWinner(attack1d, attack2n));
    }
}