package com.cb.controllers;

import com.cb.bl.UserBL;
import com.cb.dto.DefaultDTO;
import com.cb.services.dbService.dbServiceImpl.ShopDBServiceImpl;
import com.cb.services.dbService.dbServiceImpl.UserDBServiceImpl;
import com.cb.services.dbService.iDbService.FighterDBService;
import com.cb.services.dbService.iDbService.ShopDBService;
import com.cb.services.mapService.iMapService.ShopService;
import com.cb.services.mapService.iMapService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


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
    @Autowired
    ShopDBServiceImpl shopDBService;

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
    public String insertFighterWeapons(Model m, HttpServletRequest req,
                                       @RequestParam(value="1", required = false) String s1,
                                       @RequestParam(value = "2", required=false) String s2,
                                       @RequestParam(value = "3", required=false) String s3,
                                       @RequestParam(value = "4", required=false) String s4,
                                       @RequestParam(value = "5", required=false) String s5,
                                       @RequestParam(value="6", required = false) String s6,
                                       @RequestParam(value = "7", required=false) String s7,
                                       @RequestParam(value = "8", required=false) String s8,
                                       @RequestParam(value = "9", required=false) String s9,
                                       @RequestParam(value = "10", required=false) String s10,
                                       @RequestParam(value = "hidden-field", required=false) int moneyLeft) {

        HttpSession userSession = req.getSession();
        int userid = (int) userSession.getAttribute("id");

        String[] strings = {s1,s2,s3,s4,s5,s6,s7,s8,s9,s10};

        System.out.println("The current user id is: "+userid + " and this user bought " + s1);

        System.out.println("moneyLeft " + moneyLeft);
        shopDBService.updateFighterMoneyById(userid, moneyLeft);
        shopDBService.printBoughtItemsToConsole(strings, userid);

        return "shop";
    }

    @RequestMapping(method=RequestMethod.POST, value="get-fighter-money")
    public void getFighterMoney (Model m,HttpServletRequest req) {
        HttpSession userSession = req.getSession();
        int userid = (int) userSession.getAttribute("id");
        int money = fighterDBService.getFighterMoneyByUserId(userid);
        m.addAttribute("money", money);

    }



}
