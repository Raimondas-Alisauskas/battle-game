package com.cb.services.pageService.IService;

import com.cb.bl.FighterArenaBL;
import com.cb.bl.fight.*;
import com.cb.dto.DefaultDTO;
import com.cb.utils.fightUtils.FightResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArenaService {

    @Autowired
    DefaultDTO defaultDTO;

    public DefaultDTO createFight(int id1, int id2) {
        Fight fight = new Fight();
        FighterArenaBL fighterArenaBL1 = createMockFighter(id1);
        fight.setFighter1(fighterArenaBL1);
        FighterArenaBL fighterArenaBL2 = createMockFighter(id2);
        fight.setFighter2(fighterArenaBL2);
        List<FighterAction> fighter1ActionList = new ArrayList<>();
        List<FighterAction> fighter2ActionList = new ArrayList<>();
        fight.setFighter1ActionList(fighter1ActionList);
        fight.setFighter2ActionList(fighter2ActionList);

        return new DefaultDTO(true,"Pasiruošk kovoti! kovotojai sukurti",fight);
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


    public Fight adjustFightContent(int id, Fight fightSL) {
        if(fightSL.getFighter1().getId() != id){
            Fight fightSL2 = new Fight();
            fightSL2.setFighter1(fightSL.getFighter2());
            fightSL2.setFighter2(fightSL.getFighter1());
            fightSL2.setFighter1ActionList(fightSL.getFighter2ActionList());
            fightSL2.setFighter2ActionList(fightSL.getFighter1ActionList());
            return fightSL2;
        } else {return fightSL;}

    }

    public DefaultDTO askToWait(Fight fight){
        return new DefaultDTO(true,"Priešininkas grybauja. Reikia palaukti",fight);
    }

    public DefaultDTO appendActionList(int fighterId, Fight fight, List<Attack> attackList) {

        if (fight.getFighter1().getId() == fighterId){
                FighterAction fighterAction = new FighterAction(attackList,0);
                List<FighterAction> fighterActionList = fight.getFighter1ActionList();
                fighterActionList.add(fighterAction);
                fight.setFighter1ActionList(fighterActionList);
            } else
        if (fight.getFighter2().getId() == fighterId){
            FighterAction fighterAction = new FighterAction(attackList,0);
            List<FighterAction> fighterActionList = fight.getFighter2ActionList();
            fighterActionList.add(fighterAction);
            fight.setFighter2ActionList(fighterActionList);
        }

        return askToWait(fight);
    }

    public DefaultDTO calculateResults(int fighterId,Fight fight) {
        FightResolver fightResolver = new FightResolver();
        FighterAction fighterAction1 = fight.getFighter1ActionList().get(fight.getFighter1ActionList().size() -1);
        FighterAction fighterAction2 = fight.getFighter2ActionList().get(fight.getFighter2ActionList().size() -1);
        FightActionsResult fightActionsResult = fightResolver.getFightActionResult(fighterAction1, fighterAction2);

        int figter1Winnings = fightActionsResult.getFighter1Action().getNoOfWinnings();
        int figter2Winnings = fightActionsResult.getFighter2Action().getNoOfWinnings();

        fight.getFighter1ActionList().get(fight.getFighter1ActionList().size() -1).setNoOfWinnings(figter1Winnings);
        fight.getFighter2ActionList().get(fight.getFighter2ActionList().size() -1).setNoOfWinnings(figter2Winnings);

        fight = fightResolver.getHonorLeftResults(fight,fightActionsResult);


        fight.setIdHasNoHonorLeft(idWhitchHasNoHonorLeft(fight));



        defaultDTO = getResultMessage(fighterId, fight);
        Fight currentFight = (Fight) defaultDTO.getData();
        int actionsCompleted = currentFight.getActionsCompleted();
        currentFight.setActionsCompleted(actionsCompleted + 1);

        defaultDTO.setData(currentFight);

        return defaultDTO;
    }

    public int idWhitchHasNoHonorLeft(Fight fight){
        // Any fighterId will be greater than 0
        int idWithNoHonor = 0;
        int honorLeft1 = fight.getFighter1().getHonorLeft();
        int honorLeft2 = fight.getFighter2().getHonorLeft();
        if (honorLeft1 < 1){
            idWithNoHonor = fight.getFighter1().getId();
        }else if (honorLeft2 < 1){
            idWithNoHonor = fight.getFighter2().getId();
        }
        return idWithNoHonor;
    }

    public DefaultDTO getResultMessage(int fighterId, Fight fight){
        int figter1Winnings = fight.getFighter1ActionList().get(fight.getFighter1ActionList().size() -1).getNoOfWinnings();
        int figter2Winnings = fight.getFighter2ActionList().get(fight.getFighter2ActionList().size() -1).getNoOfWinnings();

        if(fight.getIdHasNoHonorLeft() > 0){
            if(fight.getIdHasNoHonorLeft() == fighterId){
                defaultDTO = new DefaultDTO(true, "Žaidimas baigtas. Nebeturi garbės", fight);
            }else {
                defaultDTO = new DefaultDTO(true, "Žaidimas baigtas. Priešininkas prarado visą garbę", fight);
            }

        }else if(figter1Winnings == figter2Winnings){
            defaultDTO = new DefaultDTO(true, "Lygiosios", fight);
        }else if (figter1Winnings > figter2Winnings){
            if (fighterId == fight.getFighter1().getId()){
                defaultDTO = new DefaultDTO(true, "Valio! laimėjai :)", fight);
            } else {
                defaultDTO = new DefaultDTO(true, "Pralaimėjai :(", fight);
            }
        }else{
            if (fighterId == fight.getFighter1().getId()){
                defaultDTO = new DefaultDTO(true, "Pralaimėjai :(", fight);
            } else {
                defaultDTO = new DefaultDTO(true, "Valio! laimėjai :)", fight);
            }
        }
        return defaultDTO;
    }


    public DefaultDTO askForMoveMessage() {
        return new DefaultDTO(true, "Nespaudinėk beleko, daryk veiksmą", null);
    }
}
