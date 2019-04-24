package com.cb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String home(HttpServletRequest req) {
        return "index";
    }
}
