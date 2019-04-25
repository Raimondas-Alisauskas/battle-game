package com.cb.services.mapService.iMapService;

import com.cb.bl.FighterBL;
import com.cb.dto.DefaultDTO;

public interface FighterService {

    DefaultDTO insertFighter(FighterBL fighterBL);

    int getFighterCountByUserId(int userId);

    DefaultDTO getFighterByUserId(int userId);

    DefaultDTO getFighters(int fighterId);

    int getFighterIdByUserId(int userId);

    DefaultDTO getCallingFighters(int fighterId);

    FighterBL getFighterByFighterId(int fighterId);

}
