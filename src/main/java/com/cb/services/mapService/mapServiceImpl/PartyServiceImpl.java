package com.cb.services.mapService.mapServiceImpl;

import com.cb.dal.PartyDAL;
import com.cb.services.dbService.iDbService.PartyDBService;
import com.cb.services.mapService.iMapService.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartyServiceImpl implements PartyService {

    @Autowired
    PartyDBService partyDBService;

    @Override
    public List<PartyDAL> getParties() {

        return partyDBService.getParties();

    }
}