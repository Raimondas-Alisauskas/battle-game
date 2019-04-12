package com.cb.service.IService;

import com.cb.bl.FighterBL;
import com.cb.bl.fight.Fight;
import com.cb.bl.fight.Weapon;
import com.cb.dto.DefaultDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArenaService {

    //not used
    public Fight createFight(int id, Fight fight) {

        if(fight.getFighter1() == null){
            FighterBL fighterBL = createMockFighter(id);
            fight.setFighter1(fighterBL);
        } else if (fight.getFighter2() == null){
            FighterBL fighterBL = createMockFighter(id);
            fight.setFighter2(fighterBL);
        } else {
            System.out.println("Error: both fighters already exist");
        }
        return fight;
    }

    public Fight createFight(int id1, int id2, Fight fight) {
            FighterBL fighterBL1 = createMockFighter(id1);
            fight.setFighter1(fighterBL1);
            FighterBL fighterBL2 = createMockFighter(id2);
            fight.setFighter2(fighterBL2);
        return fight;
    }

    private FighterBL createMockFighter(int id) {

        Weapon weapon1 = new Weapon("Deficitas: mažinamos pensijos", 1000);
        Weapon weapon2 = new Weapon("Skandalas: giminės ministerijoje", 2000);
        Weapon weapon3 = new Weapon("Skandalas: suklastotas aukštojo mokslo diplomas", 3000);
        Weapon weapon4 = new Weapon("Įstatymas: viešieji darbai už klaidingas turto deklaracija", 4000);

        List<Weapon> weaponList = new ArrayList<>();
        weaponList.add(weapon1);
        weaponList.add(weapon2);
        weaponList.add(weapon3);
        weaponList.add(weapon4);

        return new FighterBL(id, 100, 100, 100, weaponList);
    }

    public Fight adjustFightContent(int id, Fight fightS) {
        Fight fightBL = new Fight();
        if(fightS.getFighter1().getId() != id){
            fightBL.setFighter1(fightS.getFighter2());
            fightBL.setFighter2(fightS.getFighter1());
        }

        return fightBL;
    }
}
