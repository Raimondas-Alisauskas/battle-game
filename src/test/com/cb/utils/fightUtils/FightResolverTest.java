package com.cb.utils.fightUtils;

import com.cb.bl.FighterBL;
import com.cb.bl.fight.Attack;
import com.cb.bl.fight.Fight;
import com.cb.bl.fight.FightAction;
import com.cb.bl.fight.Weapon;
import com.cb.constants.AttackState;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FightResolverTest {

    FightResolver fightResolver;
    private Attack attack1a;
    private Attack attack2a;
    private Attack attack1d;
    private Attack attack2d;
    private Attack attack1n;
    private Attack attack2n;

    @Before
    public void testFightersInitialisation() {
        fightResolver = new FightResolver();
        Weapon weapon1 = new Weapon("1", 1000);
        Weapon weapon2 = new Weapon("2", 2000);

        attack1a = new Attack(1, weapon1, AttackState.ATTACK);
        attack2a = new Attack(1, weapon2, AttackState.ATTACK);
        attack1d = new Attack(1, weapon1, AttackState.DEFENCE);
        attack2d = new Attack(1, weapon2, AttackState.DEFENCE);
        attack1n = new Attack(1, weapon1, AttackState.NEUTRAL);
        attack2n = new Attack(1, weapon2, AttackState.NEUTRAL);


    }

    @Test
    public void getAttackWinnerTest() {

       Assert.assertEquals(2, fightResolver.getAttackWinner(attack1a, attack2a));
       Assert.assertEquals(2, fightResolver.getAttackWinner(attack1d, attack2d));
       Assert.assertEquals(0, fightResolver.getAttackWinner(attack1n, attack2n));
       Assert.assertEquals(0, fightResolver.getAttackWinner(attack1a, attack2d));
       Assert.assertEquals(1, fightResolver.getAttackWinner(attack1a, attack2n));
       Assert.assertEquals(1, fightResolver.getAttackWinner(attack1d, attack2n));
    }

    @Test
    public void getFightResultTest(){

        FightAction fightAction11 = new FightAction(1, attack1d);
        FightAction fightAction21 = new FightAction(2, attack2d);
        FighterBL fighterBL1 = new FighterBL(1);
        FighterBL fighterBL2 = new FighterBL(2);

        Fight fight1 = new Fight(fighterBL1, fighterBL2, fightAction11, fightAction21);

        Assert.assertEquals(2, fightResolver.getFightResult(fight1).getAttack1WinnerNo());
        Assert.assertEquals(FightResolver.WINNER_REWARD_SCORE, fightResolver.getFightResult(fight1).getFighter2Score());
    }

}