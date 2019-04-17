package com.cb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {
    @RequestMapping("/errors")
    public String errors(){
        return "errorPage";
    }
}
