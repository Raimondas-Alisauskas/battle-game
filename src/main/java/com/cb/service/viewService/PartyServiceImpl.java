package com.cb.service.viewService;

import com.cb.beans.PartyBean;
import com.cb.dao.IDao.PartyDao;
import com.cb.service.IService.PartyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PartyServiceImpl implements PartyService {

    @Autowired
    PartyDao partyDao;

    @Override
    public List<PartyBean> getParties() {

        return partyDao.getParties();

    }
}