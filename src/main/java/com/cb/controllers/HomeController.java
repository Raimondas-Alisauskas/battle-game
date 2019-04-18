package com.cb.controllers;

import com.cb.bl.FighterBL;
import com.cb.bl.UserBL;
import com.cb.dto.DefaultDTO;
import com.cb.services.mapService.iMapService.FighterService;
import com.cb.services.mapService.iMapService.UserService;
import com.cb.services.mapService.mapServiceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
    @Autowired
    UserService userService;

    @Autowired
    FighterService fighterService;

    @RequestMapping(value = "/")
    public String home() {
        return "index";
    }

    @GetMapping(value = "/home")
    public String homeAgain(Model m, UserBL userBL){
        int userId = userService.getUserIdByEmail(userBL);
        DefaultDTO defaultDTO = fighterService.getFighterByUserId(userId);
        FighterBL fighterBL = (FighterBL) defaultDTO.getData();
        m.addAttribute("fighterUser", fighterBL);
        return "home";
    }
}
