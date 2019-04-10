package com.cb.controllers;

import com.cb.bl.UserBL;
import com.cb.dal.CharacterDAL;
import com.cb.dal.PartyDAL;
import com.cb.services.mapService.iMapService.CharacterService;
import com.cb.services.mapService.iMapService.PartyService;
import com.cb.services.mapService.iMapService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    PartyService partyService;

    @Autowired
    CharacterService characterService;

    @RequestMapping(value = "/loginuser", method = RequestMethod.POST)
    public String loginUser(HttpServletRequest req, Map<String, String> model, @ModelAttribute("userDAL") UserBL userBL, Model p, Model c) {
        int userExist = userService.getUserByEmailAndPassword(userBL);

        if (userExist == 1) {
            String userName = userService.getUserNameByEmail(userBL);
            HttpSession userSession = req.getSession();
            userSession.setAttribute("userName", userName);
            List<PartyDAL> partiesList = partyService.getParties();
            List<CharacterDAL> charactersList = characterService.getCharacters();
            p.addAttribute("partiesList", partiesList);
            c.addAttribute("charactersList", charactersList);
            return "createCharacter";
        } else if (userExist == -1) {
            model.put("error", "User does not exist");
            return "index";
        } else {
            model.put("error", "General error");
            return "index";
        }
    }

    @RequestMapping(value = "/signout")
    public String signOut(HttpServletRequest req) {
        HttpSession userSession = req.getSession();
        userSession.invalidate();
        return "index";
    }
}
