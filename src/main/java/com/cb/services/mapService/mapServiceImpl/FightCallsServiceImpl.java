package com.cb.services.mapService.mapServiceImpl;

import com.cb.services.dbService.iDbService.FightCallsDBService;
import com.cb.services.mapService.iMapService.FightCallsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FightCallsServiceImpl implements FightCallsService {

    @Autowired
    FightCallsDBService fightCallsDBService;

    public int isFighterCalled(int fighterId, int calledFighterId) {

        return fightCallsDBService.isFighterCalled(fighterId, calledFighterId);

    }

    public int insertFightCall(int fighterId,int calledFighterId) {

        return fightCallsDBService.insertFightCall(fighterId, calledFighterId);

    }

}
