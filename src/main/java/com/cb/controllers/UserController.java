package com.cb.controllers;

import com.cb.beans.UserBean;
import com.cb.service.IService.UserService;
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
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/userstable")
    public String getUsersTable(Model m) {
        List<UserBean> usersList = userService.getUsers();
        m.addAttribute("usersList", usersList);
        return "usersTable";
    }

    @RequestMapping(value = "/insertnewuser", method = RequestMethod.POST)
    public String insertNewUser(@ModelAttribute("userBean") UserBean userBean) {
        userService.insertNewUser(userBean);
        return "member";
    }

    @RequestMapping(value="/insertnewuser")
    public String insertNewUser() {
        userService.insertNewUser();
        return "redirect:/userstable";
    }

    @RequestMapping(value = "/registeruser", method = RequestMethod.POST)
    public String registerUser(Map<String, String> model, @ModelAttribute("userBean") UserBean userBean) {

        List<UserBean> allEmails = userService.getUserByEmail(userBean.getEmail());

        if (allEmails.size() > 0) {

            model.put("error", "User already exist");
            return "index";
        } else {

            userService.registerUser(userBean);
            return "member";

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
    public String updateUser(@ModelAttribute("userBean") UserBean userBean) {
        userService.updateUser(userBean);
        return "redirect:/userstable";
    }

    @RequestMapping(value = "/deleteuser/{id}")
    public String getUserById(@PathVariable int id) {
        userService.deleteUserById(id);
        return "redirect:/userstable";
    }

}
