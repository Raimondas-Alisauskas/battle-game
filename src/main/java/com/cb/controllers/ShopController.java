package com.cb.controllers;

import com.cb.bl.UserBL;
import com.cb.dto.DefaultDTO;
import com.cb.services.dbService.dbServiceImpl.UserDBServiceImpl;
import com.cb.services.dbService.iDbService.FighterDBService;
import com.cb.services.mapService.iMapService.ShopService;
import com.cb.services.mapService.iMapService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class ShopController {

    @Autowired
    UserDBServiceImpl userDAL;

    @Autowired
    ShopService shopService;

    @Autowired
    UserService userService;

    @Autowired
    FighterDBService fighterDBService;

    @RequestMapping(method = RequestMethod.GET, value = "/shop")
    public String getWeaponsTable(Model m, HttpServletRequest req) {
        DefaultDTO defaultDTO = shopService.getWeapons();
        m.addAttribute("weaponsListBL", defaultDTO);

        HttpSession userSession = req.getSession();
        int userid = (int) userSession.getAttribute("id");
        String username = (String) userSession.getAttribute("userName");
        m.addAttribute("username", username);
        int money = fighterDBService.getFighterMoneyByUserId(userid);
        m.addAttribute("money", money);
        return "shop";
    }

    @RequestMapping(method=RequestMethod.POST, value="fighter-weapon-map")
    public void insertFighterWeapons(Model m, HttpServletRequest req) {

    }



}
