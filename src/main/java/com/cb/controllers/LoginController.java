package com.cb.controllers;

import com.cb.bl.FighterBL;
import com.cb.bl.UserBL;
import com.cb.dal.CharacterDAL;
import com.cb.dal.PartyDAL;
import com.cb.dto.DefaultDTO;
import com.cb.services.mapService.iMapService.CharacterService;
import com.cb.services.mapService.iMapService.FighterService;
import com.cb.services.mapService.iMapService.PartyService;
import com.cb.services.mapService.iMapService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Autowired
    FighterService fighterService;

    @RequestMapping(value = "/loginuser", method = RequestMethod.POST)
    public String loginUser(HttpServletRequest req, Map<String, String> model, @ModelAttribute("userDAL") UserBL userBL, Model m) {
        int userExist = userService.getUserByEmailAndPassword(userBL);
        int emailExist = userService.getUserByEmail(userBL);

        if (userExist == 1) {
            String userName = userService.getUserNameByEmail(userBL);
            int userId = userService.getUserIdByEmail(userBL);
            int fighterId = fighterService.getFighterIdByUserId(userId);
            HttpSession userSession = req.getSession();
            assert (userSession.isNew());
            userSession.setAttribute("userName", userName);
            userSession.setAttribute("id", userId);
            userSession.setAttribute("fighterId", fighterId);

            if (fighterService.getFighterCountByUserId(userId) == 1) {
                DefaultDTO defaultDTO = fighterService.getFighterByUserId(userId);
                FighterBL fighterBL = (FighterBL) defaultDTO.getData();
                m.addAttribute("fighterUser", fighterBL);
                userSession.setAttribute("fighterImage", fighterBL.getImage());

                return "home";

            }

            List<PartyDAL> partiesList = partyService.getParties();
            List<CharacterDAL> charactersList = characterService.getCharacters();
            m.addAttribute("partiesList", partiesList);
            m.addAttribute("charactersList", charactersList);
            return "createCharacter";
        } else if (userExist == -1 && emailExist == 1) {
            model.put("error", "Bad password, please try again");
            return "index";
        } else {
            model.put("error", "General error");
            return "errorPage";
        }
    }

    @GetMapping(value = "/loginuser")
    public String refreshMyProfile() {

        return "home";
    }

        @RequestMapping(value = "/signout")
        public String signOut (HttpServletRequest req){
            HttpSession userSession = req.getSession();
            userSession.invalidate();
            return "index";
        }
    }
