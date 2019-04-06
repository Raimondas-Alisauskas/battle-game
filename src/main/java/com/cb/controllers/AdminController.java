package com.cb.controllers;

import com.cb.dal.CharacterDAL;
import com.cb.dal.PartyDAL;
import com.cb.dal.UserDAL;
import com.cb.dto.DefaultDTO;
import com.cb.services.service.IService.UserService;
import com.cb.services.service.IService.CharacterService;

import com.cb.services.service.IService.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    PartyService partyService;

    @Autowired
    CharacterService characterService;

    @RequestMapping("/userstable")
    public String getUsersTable(Model m) {
        DefaultDTO defaultDTO = userService.getUsers();
        m.addAttribute("usersListBL", defaultDTO);
        return "admin";
    }

    @RequestMapping(value = "/insertnewuser", method = RequestMethod.POST)
    public String insertNewUser(@ModelAttribute("userBean") UserDAL userDAL) {
        userService.insertNewUser(userDAL);
        return "createCharacter";
    }

    @RequestMapping(value = "/insertnewuser")
    public String insertNewUser() {
        userService.insertNewUser();
        return "redirect:/userstable";
    }

    @RequestMapping(value = "/registeruser", method = RequestMethod.POST)
    public String registerUser(Map<String, String> model, @ModelAttribute("userBean") UserDAL userDAL, Model p, Model c) {

        System.out.println();

        List<UserDAL> allEmails = userService.getUserByEmail(userDAL.getEmail());

        if (allEmails.size() > 0) {

            model.put("error", "User already exist");
            return "index";
        } else {

            userService.registerUser(userDAL);
            List<PartyDAL> partiesList = partyService.getParties();
            List<CharacterDAL> charactersList = characterService.getCharacters();
            p.addAttribute("partiesList", partiesList);
            c.addAttribute("charactersList", charactersList);
            return "createCharacter";

        }

    }

    /* Displays object data into form for the given id.
     * The @PathVariable puts URL data into variable.*/
    @RequestMapping(value = "/edituser/{id}")
    public String getUserById(@PathVariable int id, Model m) {
        m.addAttribute("command", userService.getUserById(id));
        return "userForm";
    }

    /*Inserts object into database. The @ModelAttribute puts request data
     *  into model object. */
    @RequestMapping(value = "/edituser/update", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("userBean") UserDAL userDAL) {
        userService.updateUser(userDAL);
        return "redirect:/userstable";
    }

    @RequestMapping(value = "/deleteuser/{id}")
    public String getUserById(@PathVariable int id) {
        userService.deleteUserById(id);
        return "redirect:/userstable";
    }

}
