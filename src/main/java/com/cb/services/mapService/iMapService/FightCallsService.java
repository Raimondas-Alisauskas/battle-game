package com.cb.services.mapService.iMapService;

public interface FightCallsService {

    int isFighterCalled(int fighterId, int calledFighterId);

    int insertFightCall(int fighterId,int calledFighterId);

}
