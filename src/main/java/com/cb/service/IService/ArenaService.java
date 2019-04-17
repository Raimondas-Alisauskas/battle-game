package com.cb.service.IService;

import com.cb.bl.FighterArenaBL;
import com.cb.bl.fight.Attack;
import com.cb.bl.fight.Fight;
import com.cb.bl.fight.Weapon;
import com.cb.dto.DefaultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArenaService {

    public static final int WINNER_REWARD_SCORE = 10;
    @Autowired
    DefaultDTO fightDTO;

    public DefaultDTO createFight(int id1, int id2) {
        Fight fight = new Fight();
        FighterArenaBL fighterArenaBL1 = createMockFighter(id1);
        fight.setFighter1(fighterArenaBL1);
        FighterArenaBL fighterArenaBL2 = createMockFighter(id2);
        fight.setFighter2(fighterArenaBL2);
        return new DefaultDTO(true,"Pasiruošk kovoti!",fight);
    }

    private FighterArenaBL createMockFighter(int id) {

        Weapon weapon1 = new Weapon("Deficitas: mažinamos pensijos", 1000);
        Weapon weapon2 = new Weapon("Skandalas: giminės ministerijoje", 2000);
        Weapon weapon3 = new Weapon("Skandalas: suklastotas aukštojo mokslo diplomas", 3000);
        Weapon weapon4 = new Weapon("Įstatymas: viešieji darbai už klaidingas turto deklaracija", 4000);

        List<Weapon> weaponList = new ArrayList<>();
        weaponList.add(weapon1);
        weaponList.add(weapon2);
        weaponList.add(weapon3);
        weaponList.add(weapon4);

        return new FighterArenaBL(id, 100, 100, 100, weaponList);
    }

    public DefaultDTO adjustFightContent(int id, Fight fightSL) {
        if(fightSL.getFighter1().getId() != id){
            Fight fightBL = new Fight();
            fightBL.setFighter1(fightSL.getFighter2());
            fightBL.setFighter2(fightSL.getFighter1());
            fightBL.setFighter1ActionList(fightSL.getFighter2ActionList());
            fightBL.setFighter2ActionList(fightSL.getFighter1ActionList());
            fightDTO.setData(fightBL);
        } else {fightDTO.setData(fightSL);}
        fightDTO.setMessage("Pirmyn į kovą!");
        return fightDTO;
    }

    public DefaultDTO askToWait(Fight fightSL){
        return new DefaultDTO(true,"Priešininkas grybauja. Reikia palaukti",fightSL);
    }

    public DefaultDTO fillActionListOrGetResult(int fighterId, Fight fight, List<Attack> attackList) {


        return fightDTO;
    }
}
