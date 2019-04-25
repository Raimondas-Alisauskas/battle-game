package com.cb.services.mapService.iMapService;

import com.cb.dto.DefaultDTO;

public interface FightCallsService {

    int isFighterCalled(int fighterId, int calledFighterId);

    int isFighterAccepted(int fighterId, int calledFighterId);

    int insertFightCall(int fighterId,int calledFighterId);

    DefaultDTO getCallingFighter(int fighterId);

    int updateFightCallRowSetOnFightTrue(int fighter1, int fighter2);

    int deleteFightCallRow(int fighter1, int fighter2);

}
