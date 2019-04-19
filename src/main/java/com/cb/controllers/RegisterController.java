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
public class RegisterController {
    @Autowired
    UserService userService;

    @Autowired
    PartyService partyService;

    @Autowired
    CharacterService characterService;

    @Autowired
    FighterService fighterService;

    @RequestMapping(value = "/registeruser", method = RequestMethod.POST)
    public String registerUser(HttpServletRequest req, Map<String, String> model, @ModelAttribute("userDAL") UserBL userBL, Model m) {
        int userExist = userService.getUserByEmail(userBL);
        String userName = userBL.getUserName();


        if (userExist == 1) {
            model.put("error", "User already exist");
            return "index";
        } else if (userExist == -1) {
            userService.registerUser(userBL);
            int userId = userService.getUserIdByEmail(userBL);
            HttpSession userSession = req.getSession();
            userSession.setAttribute("userName", userName);
            userSession.setAttribute("id", userId);
            List<PartyDAL> partiesList = partyService.getParties();
            List<CharacterDAL> charactersList = characterService.getCharacters();
            m.addAttribute("partiesList", partiesList);
            m.addAttribute("charactersList", charactersList);

            return "createCharacter";
        } else {
            model.put("error", "General error");
            return "index";
        }

    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String createNewCharacter(HttpServletRequest req, @ModelAttribute FighterBL fighterBL, Model m) {

        HttpSession httpSession = req.getSession();
        int userId = (int) httpSession.getAttribute("id");

        int characterId = characterService.getCharacterId(fighterBL);
        int partyId = partyService.getPartyId(fighterBL);


        fighterBL.setUserId(userId);
        fighterBL.setCharacterId(characterId);
        fighterBL.setPartyId(partyId);

        fighterService.insertFighter(fighterBL);
        int fighterId = fighterService.getFighterIdByUserId(userId);
        httpSession.setAttribute("fighterId", fighterId);
        httpSession.setAttribute("fighterImage", fighterBL.getImage());

        System.out.println("Image after registration: " + fighterBL.getImage());

        DefaultDTO defaultDTO = fighterService.getFighterByUserId(userId);
        fighterBL = (FighterBL) defaultDTO.getData();
        m.addAttribute("fighterUser", fighterBL);

        return "home";

    }
}
