package com.cb.services.service.ServiceImpl;

import com.cb.dal.PartyDAL;
import com.cb.services.DBService.IDBService.PartyDBService;
import com.cb.services.service.IService.PartyService;
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