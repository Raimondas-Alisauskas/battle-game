package com.cb.services.dbService.iDbService;

import com.cb.dal.FightCallsDAL;

import java.util.List;

public interface FightCallsDBService {

    List<FightCallsDAL> getFightCalls();

    int isFighterCalled(int fighterId, int calledFighterId);

    int isFighterAccepted(int fighterId, int calledFighterId);

    int amICalled(int fighterId, int calledFighterId);

    int insertFightCall(int fighterId,int calledFighterId);

    List<FightCallsDAL> getCallingFighterId(int fighterId);

    int updateFightCallRowSetOnFightTrue(int fighter1, int fighter2);

    int deleteFightCallRow(int fighter1,int fighter2);

}
