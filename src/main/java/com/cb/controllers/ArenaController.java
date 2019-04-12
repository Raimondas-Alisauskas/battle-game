package com.cb.controllers;

import com.cb.bl.fight.Fight;
import com.cb.dto.DefaultDTO;
import com.cb.service.IService.ArenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;


@Controller
public class ArenaController extends HttpServlet {

    @Autowired
    ArenaService arenaService;

    DefaultDTO defaultDTO;




    @RequestMapping(value = "/arenadraft")
    public String arenaDraft() {
        return "arena";
    }

    @RequestMapping(value = "/getfight")
    public String getFight(@RequestParam(value="id1") int id1,
                        @RequestParam(value="id2", required=false) int id2,
                        Model m, HttpServletRequest req ){

        req.getSession().setAttribute("id", id1);//Temporary code.

        int id = (int) req.getSession().getAttribute("id");
        Fight fightBL;
        ServletContext servletContext = req.getServletContext();
        Fight fightS = (Fight) servletContext.getAttribute("fightS");
        if(fightS == null) {
            fightBL = arenaService.createFight(id1, id2, new Fight());
            servletContext.setAttribute("fightS", fightBL);
        }else{
            fightBL = arenaService.adjustFightContent(id, fightS);
        }
        m.addAttribute("fight", fightBL);

        return "arenaTst";
    }

    @RequestMapping(value = "/fight")
    public String fight(@RequestParam(value="power1") int power1,
                           @RequestParam(value="option1") int option1,
                           Model m, HttpServletRequest req ){

        ServletContext servletContext = req.getServletContext();
        Fight fight = (Fight) servletContext.getAttribute("fight");
        if(fight == null){
//            fight = arenaService.createFight(id1, id2, new Fight());
//        }else {
//            fight = arenaService.createFight(id2, fight);
        }
        //        context.setAttribute("fight",fight);
        m.addAttribute("fight", fight);
        return "arenaTst";
    }









//    @RequestMapping("/arena/{id1}-{id2}")
//    public String handleRequest3 (@PathVariable("id1") int id1,
//                                  @PathVariable("id2") int id2,
//                                  Model m) {
//        fight = arenaService.createFight(id1, fight);
//        m.addAttribute("fighterBL", fight.getFighter2());
//        return "arenaTst";
//    }

}
