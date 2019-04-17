package com.cb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String home() {
        return "index";
    }

    @RequestMapping("/selectopponent")
    public String selectOpponent(){
        return "selectOpponent";
    }

}
