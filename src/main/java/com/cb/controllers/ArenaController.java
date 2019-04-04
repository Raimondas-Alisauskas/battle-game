package com.cb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ArenaController {

    @RequestMapping(value = "/arena")
    public String arena() {
        return "arena";
    }

}
