package com.cb.utils.fightUtils;

import com.cb.bl.fight.Attack;
import com.cb.bl.fight.FightAction;
import com.cb.bl.fight.Weapon;
import com.cb.constants.AttackType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

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

        attack1a = new Attack(1, weapon1, AttackType.ATTACK, null);
        attack2a = new Attack(1, weapon2, AttackType.ATTACK,null);
        attack1d = new Attack(1, weapon1, AttackType.DEFENCE, null);
        attack2d = new Attack(1, weapon2, AttackType.DEFENCE, null);
        attack1n = new Attack(1, weapon1, AttackType.NEUTRAL, null);
        attack2n = new Attack(1, weapon2, AttackType.NEUTRAL, null);
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
    public void getFightActionResultTest(){
        List<Attack> attackList1 = new ArrayList<>();
        List<Attack> attackList2 = new ArrayList<>();

        attackList1.add(attack1a);
        attackList1.add(attack2a);

        attackList2.add(attack2a);
        attackList2.add(attack2a);

        FightAction fightAction1 = new FightAction(1, attackList1, 0);
        FightAction fightAction2 = new FightAction(1, attackList2, 0);

        Assert.assertEquals(0, fightResolver.getFightActionResult(fightAction1,fightAction2).getFighter1Action().getNoOfWinnings());
        Assert.assertEquals(1, fightResolver.getFightActionResult(fightAction1,fightAction2).getFighter2Action().getNoOfWinnings());
    }

}