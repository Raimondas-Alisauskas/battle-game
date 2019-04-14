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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;


@Controller
public class ArenaController extends HttpServlet {

    @Autowired
    ArenaService arenaService;

    @Autowired
    DefaultDTO defaultDTO;




    @RequestMapping(value = "/arenadraft")
    public String arenaDraft() {
        return "arena";
    }

    @RequestMapping(value = "/arena")
    public String getFight(@RequestParam(value="id1") int id1,
                        @RequestParam(value="id2", required=false) int id2,
                        Model m, HttpServletRequest req ){

        req.getSession().setAttribute("fighterId", id1);//Temporary code.

        int id = (int) req.getSession().getAttribute("fighterId");
        Fight fightBL;
        ServletContext servletContext = req.getServletContext();
        Fight fightSL = (Fight) servletContext.getAttribute("fightSL");
        if(fightSL == null) {
            defaultDTO = arenaService.createFight(id1, id2);
            servletContext.setAttribute("fightSL", defaultDTO.getData());
        }else{
            defaultDTO = arenaService.adjustFightContent(id, fightSL);
        }

        m.addAttribute("defaultDTO", defaultDTO);

        return "arenaTst";
    }

    @RequestMapping(value = "arena/fight")
    public String doGet(@RequestParam(value="power1") String power1,
                           @RequestParam(value="option1") String option1,
                           Model m, HttpServletRequest req ){

        ServletContext servletContext = req.getServletContext();
        Fight fightS = (Fight) servletContext.getAttribute("fightS");
        int fighterId = (int) req.getSession().getAttribute("fighterId");
        if(fightS.getFighter1ActionList().size() == fightS.getActionsCompleted()
            || fightS.getFighter2ActionList().size() == fightS.getActionsCompleted()){
            defaultDTO = arenaService.fillActionListOrGetResult(fighterId, fightS);
        } else {
            defaultDTO = arenaService.askToWait(fightS);
        }
        fightS = (Fight) defaultDTO.getData();
        servletContext.setAttribute("fightS", fightS);
        m.addAttribute("defaultDTO", defaultDTO);
        return "arenaTst";
    }

    //Temporary, for tests
    @RequestMapping(value = "arena/deletefight")
    public String deleteFight (Model m, HttpServletRequest req){
        Fight fightBL = (Fight) req.getServletContext().getAttribute("fightS");
        req.getServletContext().setAttribute("fightS", null);
        defaultDTO.setData(fightBL);
        m.addAttribute("defaultDTO", defaultDTO);
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
