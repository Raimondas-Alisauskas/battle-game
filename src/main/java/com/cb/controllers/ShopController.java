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
    public String insertFighterWeapons(Model m, HttpServletRequest req, @RequestParam(value = "2", required=false) String s2,
                                       @RequestParam(value = "3", required=false) String s3,
                                       @RequestParam(name = "4", required=false) String s4,
                                       @RequestParam(value = "5", required=false) String s5,
                                       @RequestParam(value = "hidden-field", required=false) int moneyLeft) {

        HttpSession userSession = req.getSession();
        int userid = (int) userSession.getAttribute("id");
        System.out.println("The current user id is: "+userid + " and this user bought " + s2);
        System.out.println("The current user id is: "+userid + " and this user bought " + s3);
        System.out.println("The current user id is: "+userid + " and this user bought " + s4);
        System.out.println("The current user id is: "+userid + " and this user bought " + s5);

        System.out.println("moneyLeft " + moneyLeft);
        shopDBService.updateFighterMoneyById(userid, moneyLeft);


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
