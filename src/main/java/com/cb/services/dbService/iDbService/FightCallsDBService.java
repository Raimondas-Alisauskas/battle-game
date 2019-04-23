package com.cb.services.dbService.iDbService;

import com.cb.dal.FightCallsDAL;

import java.util.List;

public interface FightCallsDBService {

    List<FightCallsDAL> getFightCalls();

    int isFighterCalled(int fighterId, int calledFighterId);

    int insertFightCall(int fighterId,int calledFighterId);

}
