package com.cb.services.dbService.iDbService;

import com.cb.bl.FighterBL;
import com.cb.dal.PartyDAL;

import java.util.List;

public interface PartyDBService {

    List<PartyDAL> getParties();

    int getPartyId(FighterBL fighterBL);

    String getPartyName(int partyId);

}
