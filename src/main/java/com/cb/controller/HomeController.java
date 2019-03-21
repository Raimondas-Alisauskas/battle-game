package com.cb.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import com.cb.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        return "index";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String user(User user, Model model) {

        model.addAttribute("userName", user.getUserName());
        return "user";
    }
}
