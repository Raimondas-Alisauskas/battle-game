package com.cb.services.dbService.iDbService;

import com.cb.dal.PartyDAL;

import java.util.List;

public interface PartyDBService {

    List<PartyDAL> getParties();

}
