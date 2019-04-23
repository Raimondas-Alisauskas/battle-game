package com.cb.controllers;

import com.cb.bl.FightCallsBL;
import com.cb.dto.DefaultDTO;
import com.cb.services.mapService.iMapService.FightCallsService;
import com.cb.services.mapService.iMapService.FighterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class FighterListController {

    @Autowired
    FighterService fighterService;

    @Autowired
    FightCallsService fightCallsService;

    @RequestMapping(value = "/fighterlist")
    public String fighterList(HttpServletRequest req, Model m) {

        HttpSession httpSession = req.getSession();
        int userId = (int) httpSession.getAttribute("id");
        int fighterId = (int) httpSession.getAttribute("fighterId");

        DefaultDTO defaultDTO = fighterService.getFighters(fighterId);

        m.addAttribute("fighterList", defaultDTO);

        return "fighterList";

    }

    @RequestMapping(value = "/callfight")
    public String callFight(HttpServletRequest req, @ModelAttribute FightCallsBL fightCallsBL , Model m) {

        HttpSession httpSession = req.getSession();
        int fighterId = (int) httpSession.getAttribute("fighterId");
        fightCallsService.insertFightCall(fighterId,fightCallsBL.getCalledFighter());

        return "redirect:/fighterlist";


    }


}
