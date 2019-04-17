package com.cb.services.mapService.iMapService;

import com.cb.bl.FighterBL;
import com.cb.dal.PartyDAL;

import java.util.List;

public interface PartyService {

    List<PartyDAL> getParties();

    int getPartyId(FighterBL fighterBL);

    String getPartyName(int partyId);

}
