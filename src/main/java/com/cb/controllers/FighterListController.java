package com.cb.controllers;

import com.cb.services.mapService.iMapService.FighterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

public class FighterListController {

    @Autowired
    FighterService fighterService;

    @RequestMapping(value = "/fighterlist", method = RequestMethod.POST)
    public String getFighters(HttpServletResponse req, Model m) {

        return "fighterList";

    }

}
