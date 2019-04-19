package com.cb.services.dbService.iDbService;

import com.cb.bl.FighterBL;
import com.cb.dal.FighterDAL;

import java.util.List;

public interface FighterDBService {

    int insertFighter(FighterBL f);

    int getFighterCountByUserId(int userId);

    List<FighterDAL> getFighters();

    FighterDAL getFighterByUserId(int userId);

    int getFighterIdByUserId(int userId);

}
