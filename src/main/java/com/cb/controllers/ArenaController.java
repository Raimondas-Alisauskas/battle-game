package com.cb.controllers;

import com.cb.bl.fight.Attack;
import com.cb.bl.fight.Fight;
import com.cb.dto.DefaultDTO;
import com.cb.services.pageService.IService.ArenaService;

import com.cb.utils.fightUtils.ControllerUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;



@Controller
public class ArenaController extends HttpServlet {

    @Autowired
    ArenaService arenaService;

    @Autowired
    DefaultDTO defaultDTO;

    @Autowired
    ControllerUtility conUtil;

    @RequestMapping(value = "/arenadraft")
    public String arenaDraft() {
        return "arena";
    }

    @RequestMapping(value = "/arena")
    public String getFight(@RequestParam(value="id1") int id1,
                           @RequestParam(value="id2", required=false) int id2,
                           Model m, HttpServletRequest req ){

        req.getSession().setAttribute("fighterId", id1);//Temporary code.

        int fighterId = (int) req.getSession().getAttribute("fighterId");
        ServletContext servletContext = req.getServletContext();
        Fight fightSL = (Fight) servletContext.getAttribute("fightSL");
        DefaultDTO defaultDTO = new DefaultDTO();
        if(fightSL == null) {
            defaultDTO = arenaService.createFight(id1, id2);
            servletContext.setAttribute("fightSL", defaultDTO.getData());
        }else{
            defaultDTO.setData(arenaService.adjustFightContent(fighterId, fightSL));
        }
        m.addAttribute("defaultDTO", defaultDTO);
        return "arenaTst";
    }

    @RequestMapping(value = "arena/fight")
    public String fight(@RequestParam(value="weapon1") String weapon1,
                        @RequestParam(value="attType1") String attType1,
                        Model m, HttpServletRequest req ){

        ServletContext servletContext = req.getServletContext();
        Fight fightSL = (Fight) servletContext.getAttribute("fightSL");

        int fighterId = (int) req.getSession().getAttribute("fighterId");

        List<Attack> attackList = new ArrayList<>();
        Attack attack1 = new Attack(1,conUtil.getWeaponFromAttribute(weapon1),conUtil.getAttackTypeFromString(attType1), false);
        attackList.add(attack1);
        DefaultDTO defaultDTO ;

        //if actionList size equal actionsCompleted number: add Action to ActionList
        if(fighterId == fightSL.getFighter1().getId() && fightSL.getFighter1ActionList().size() == fightSL.getActionsCompleted()){
            defaultDTO = arenaService.appendActionList(fighterId, fightSL, attackList);
            fightSL = (Fight) defaultDTO.getData();
        }else if(fighterId == fightSL.getFighter2().getId() && fightSL.getFighter2ActionList().size() == fightSL.getActionsCompleted()){
            defaultDTO = arenaService.appendActionList(fighterId, fightSL, attackList);
            fightSL = (Fight) defaultDTO.getData();
        }

        //if Results are not viewed and both ActionList sizes bigger than ActionsCompleted: calculate results
        if(fightSL.getFighter1ActionList().size() > fightSL.getActionsCompleted()
            && fightSL.getFighter2ActionList().size() > fightSL.getActionsCompleted()){
            defaultDTO = arenaService.calculateResults(fighterId, fightSL );

            fightSL = (Fight) defaultDTO.getData();

        //if only one ActionList sizes bigger than ActionsCompleted:  ask to wait
        }else{
            defaultDTO = arenaService.askToWait(fightSL);
            fightSL = (Fight) defaultDTO.getData();
        }
        defaultDTO.setData(arenaService.adjustFightContent(fighterId, fightSL));

        servletContext.setAttribute("fightSL", fightSL);
        m.addAttribute("defaultDTO", defaultDTO);
        // Any fighterId will be greater than 0
        if (fightSL.getIdHasNoHonorLeft() > 0){
            return "arenaFinish";
        }else return "arenaTst";

    }

    @RequestMapping(value = "arena/getresults")
    public String refresh (Model m, HttpServletRequest req){
        ServletContext servletContext = req.getServletContext();
        Fight fightSL = (Fight) servletContext.getAttribute("fightSL");
        Fight fightBL= org.apache.commons.lang3.SerializationUtils.clone(fightSL);
        int fighterId = (int) req.getSession().getAttribute("fighterId");
        DefaultDTO defaultDTO;

        if(fightBL.getFighter1ActionList().size() == fightBL.getActionsCompleted() && fightBL.getActionsCompleted() > 0
                && fightBL.getFighter2ActionList().size() == fightBL.getActionsCompleted() && fightBL.getActionsCompleted() > 0) {
            defaultDTO = arenaService.getResultMessage(fighterId, fightSL);
            defaultDTO.setData(arenaService.adjustFightContent(fighterId, fightSL));

        }else if(fightBL.getFighter1ActionList().size() > fightBL.getActionsCompleted() && fighterId == fightBL.getFighter2().getId() ){
             fightBL.getFighter1ActionList().remove(fightBL.getFighter1ActionList().size() -1);
             defaultDTO = arenaService.askForMoveMessage();
            defaultDTO.setData(arenaService.adjustFightContent(fighterId, fightBL));

        }else if(fightBL.getFighter2ActionList().size() > fightBL.getActionsCompleted() && fighterId == fightBL.getFighter1().getId() ) {
            fightBL.getFighter2ActionList().remove(fightBL.getFighter2ActionList().size() - 1);
            defaultDTO = arenaService.askForMoveMessage();
            defaultDTO.setData(arenaService.adjustFightContent(fighterId, fightBL));
        }else {
            defaultDTO = arenaService.askToWait(fightBL);
            defaultDTO.setData(arenaService.adjustFightContent(fighterId, fightBL));
        }

        m.addAttribute("defaultDTO", defaultDTO);
        // Any fighterId will be greater than 0
        if (fightSL.getIdHasNoHonorLeft() > 0){
            return "arenaFinish";
        }else return "arenaTst";
    }

    //Temporary, for tests
    @RequestMapping(value = "arena/deletefight")
    public String deleteFight (Model m, HttpServletRequest req){
        ServletContext servletContext = req.getServletContext();
        Fight fightBL = (Fight) servletContext.getAttribute("fightSL");
        DefaultDTO defaultDTO = new DefaultDTO();
        defaultDTO.setData(fightBL);
        req.getServletContext().setAttribute("fightSL", null);
        fightBL = (Fight) servletContext.getAttribute("fightSL");

        m.addAttribute("defaultDTO", defaultDTO);
        return "arenaTst";
    }

}
