package com.cb.controllers;

import com.cb.dto.DefaultDTO;
import com.cb.services.mapService.iMapService.FighterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class FighterListController {

    @Autowired
    FighterService fighterService;

    @RequestMapping(value = "/fighterlist")
    public String fighterList(HttpServletRequest req, Model m) {

        HttpSession httpSession = req.getSession();
        int userId = (int) httpSession.getAttribute("id");

        DefaultDTO defaultDTO = fighterService.getFighters(userId);
        m.addAttribute("fighterList", defaultDTO);

        return "fighterList";

    }

}
