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




    public DefaultDTO createFight(int id1, int id2) {

        FighterBL fighterBL1 = createMockFighter(id1);
        FighterBL fighterBL2 = createMockFighter(id2);

        DefaultDTO defaultDTO = new DefaultDTO();
        defaultDTO.setData(fighterBL1);

        return defaultDTO;
    }

    public FighterBL createMockFighter(int id) {

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
}
