package com.cb.controllers;


import com.cb.bl.UserBL;
import com.cb.dto.DefaultDTO;
import com.cb.services.mapService.iMapService.CharacterService;
import com.cb.services.mapService.iMapService.PartyService;
import com.cb.services.mapService.iMapService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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
    public String insertNewUser(@ModelAttribute("userDAL") UserBL userBL) {
        userService.insertNewUser(userBL);
        return "createCharacter";
    }

    @RequestMapping(value = "/insertnewuser")
    public String insertNewUser() {
        userService.insertNewUser();
        return "redirect:/userstable";
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
    public String updateUser(@ModelAttribute("userDAL") UserBL userBL) {
        userService.updateUser(userBL);
        return "redirect:/userstable";
    }

    @RequestMapping(value = "/deleteuser/{id}")
    public String getUserById(@PathVariable int id) {
        userService.deleteUserById(id);
        return "redirect:/userstable";
    }

}
