package com.cb.controllers;

import com.cb.beans.UserBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/")
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String user(UserBean userBean, Model model) {

        model.addAttribute("userName", userBean.getUserName());
        return "userForm";
    }
}
