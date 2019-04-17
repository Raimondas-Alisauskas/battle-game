package com.cb.controllers;

import com.cb.dto.DefaultDTO;
import com.cb.services.dbService.dbServiceImpl.UserDBServiceImpl;
import com.cb.services.mapService.iMapService.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ShopController {

    @Autowired
    UserDBServiceImpl userDAL;

    @Autowired
    ShopService shopService;

    @RequestMapping(method = RequestMethod.GET, value = "/shop")
    public String getWeaponsTable(Model m) {
        DefaultDTO defaultDTO = shopService.getWeapons();
        m.addAttribute("weaponsListBL", defaultDTO);
        return "shop";
    }


//    @RequestMapping(method = RequestMethod.GET, value = "/shop")
//    public String arena() {
//        List<String> weapons = userDAL.getField();
//        for(String s : weapons){
//            System.out.println(s);
//        }
//        return "shop";
//    }

}
