package com.cb.controllers;

import com.cb.bl.fight.Fight;
import com.cb.dto.DefaultDTO;
import com.cb.service.IService.ArenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ArenaController {

    @Autowired
    ArenaService arenaService;

    @RequestMapping(value = "/arenadraft")
    public String arenaDraft() {
        return "arena";
    }

    @RequestMapping(value = "/arena")
    public String arena(@RequestParam(value="id1") int id1,
                        @RequestParam(value="id2", required=false) int id2,
                        Model m){
        DefaultDTO defaultDTO = arenaService.createFight(id1, id2);
        m.addAttribute("fighterBL", defaultDTO.getData());
        return "arenaTst";
    }

    @RequestMapping("/arena/{id1}-{id2}")
    public String handleRequest3 (@PathVariable("id1") int id1,
                                  @PathVariable("id2") int id2,
                                  Model m) {
        DefaultDTO defaultDTO = arenaService.createFight(id1, id2);
        m.addAttribute("fighterBL", defaultDTO.getData());
        return "arenaTst";
    }

}
