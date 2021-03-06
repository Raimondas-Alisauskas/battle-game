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

    @RequestMapping(value = "/loginuser")
    public String loginUser(HttpServletRequest req, Map<String, String> model, @ModelAttribute("userDAL") UserBL userBL, Model m) {

        HttpSession userSession = req.getSession();
        if (userSession.getAttribute("id") == null) {

            int userExist = userService.getUserByEmailAndPassword(userBL);

            if (userExist == 1) {
                String userName = userService.getUserNameByEmail(userBL);
                int userId = userService.getUserIdByEmail(userBL);
                int fighterId = fighterService.getFighterIdByUserId(userId);
                userSession.setAttribute("userName", userName);
                userSession.setAttribute("id", userId);
                userSession.setAttribute("fighterId", fighterId);

                if (fighterService.getFighterCountByUserId(userId) == 1) {
                    DefaultDTO defaultDTO = fighterService.getFighterByUserId(userId);
                    FighterBL fighterBL = (FighterBL) defaultDTO.getData();
                    m.addAttribute("fighterUser", fighterBL);
                    userSession.setAttribute("fighterImage", fighterBL.getImage());

                    m.addAttribute("callingFighters", fighterService.getCallingFighters(fighterId));

                    return "home";

                }

                List<PartyDAL> partiesList = partyService.getParties();
                List<CharacterDAL> charactersList = characterService.getCharacters();
                m.addAttribute("partiesList", partiesList);
                m.addAttribute("charactersList", charactersList);
                return "createCharacter";
            } else if (userExist == -1) {
                model.put("error", "User does not exist");
                return "index";
            } else {
                model.put("error", "General error");
                return "index";
            }
        }

        if (userSession.getAttribute("id") != null) {

            int fighterId = fighterService.getFighterIdByUserId((int) userSession.getAttribute("id"));
            DefaultDTO defaultDTO = fighterService.getFighterByUserId((int) userSession.getAttribute("id"));
            FighterBL fighterBL = (FighterBL) defaultDTO.getData();
            m.addAttribute("fighterUser", fighterBL);
            m.addAttribute("callingFighters", fighterService.getCallingFighters(fighterId));

            return "home";

        }


        return "home";

    }

    @RequestMapping(value = "/signout")
    public String signOut(HttpServletRequest req) {
        HttpSession userSession = req.getSession();
        userSession.invalidate();
        return "redirect:/";
    }
}
