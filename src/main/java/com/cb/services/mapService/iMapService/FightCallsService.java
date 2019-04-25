package com.cb.services.mapService.iMapService;

import com.cb.dto.DefaultDTO;

public interface FightCallsService {

    int isFighterCalled(int fighterId, int calledFighterId);

    int insertFightCall(int fighterId,int calledFighterId);

    DefaultDTO getCallingFighter(int fighterId);

}
