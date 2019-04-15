package com.cb.services.mapService.mapServiceImpl;

import com.cb.bl.FighterBL;
import com.cb.bl.UserBL;
import com.cb.dto.DefaultDTO;
import com.cb.services.dbService.iDbService.FighterDBService;
import com.cb.services.mapService.iMapService.FighterService;
import org.springframework.beans.factory.annotation.Autowired;

public class FighterServiceImpl implements FighterService {

    @Autowired
    FighterDBService fighterDBService;
    @Autowired
    DefaultDTO defaultDTO;

    public DefaultDTO insertFighter(FighterBL fighterBL) {

        fighterBL.setMoney(1000);
        fighterBL.setRating(1000);

        if (fighterDBService.insertFighter(fighterBL) == 1) {

            defaultDTO.setSuccess(true);

        } else {
            defaultDTO.setSuccess(false);
            defaultDTO.setMessage("General error: can't insert fighter");
        }

        return defaultDTO;

    }

}

