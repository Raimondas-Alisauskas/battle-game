package com.cb.controllers;

import com.cb.dal.CharacterDAL;
import com.cb.dal.PartyDAL;
import com.cb.dal.UserDAL;
import com.cb.services.service.IService.CharacterService;
import com.cb.services.service.IService.PartyService;
import com.cb.services.service.IService.UserService;
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
    public String loginUser(HttpServletRequest req, Map<String, String> model, @ModelAttribute("userBean") UserDAL userDAL, Model p, Model c) {
        List<UserDAL> allEmails = userService.getUserByEmail(userDAL.getEmail());
        List<UserDAL> allPasswords = userService.getUserByPassword(userDAL.getPassword());
        String userName = "";
        for (UserDAL items: allEmails
        ) {
            userName = items.getUserName();
        }

        if (allEmails.size() > 0 && allPasswords.size() > 0) {
            HttpSession userSession = req.getSession();
            userSession.setAttribute("userName", userName);
            List<PartyDAL> partiesList = partyService.getParties();
            List<CharacterDAL> charactersList = characterService.getCharacters();
            p.addAttribute("partiesList", partiesList);
            c.addAttribute("charactersList", charactersList);
            return "createCharacter";

        } else {
            model.put("error", "User does not exist");
            return "index";

        }
    }
}
