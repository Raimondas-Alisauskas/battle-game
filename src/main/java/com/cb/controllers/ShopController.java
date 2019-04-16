package com.cb.controllers;

import com.cb.dal.UserDAL;
import com.cb.services.dbService.dbServiceImpl.UserDBServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ShopController {

    @Autowired
    UserDBServiceImpl userDAL;

    @RequestMapping(method = RequestMethod.GET, value = "/shop")
    public String arena() {
        List<String> weapons = userDAL.getField();
        for(String s : weapons){
            System.out.println(s);
        }
        return "shop";
    }

}
