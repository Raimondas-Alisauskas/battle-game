package com.cb.services.dbService.iDbService;

import com.cb.dal.WeaponsDAL;

import java.util.List;

public interface ShopDBService {
    List<WeaponsDAL> getWeapons();
}
