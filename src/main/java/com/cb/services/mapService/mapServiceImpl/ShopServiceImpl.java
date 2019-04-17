package com.cb.services.mapService.mapServiceImpl;

import com.cb.bl.ShopBL;
import com.cb.dal.WeaponsDAL;
import com.cb.dto.DefaultDTO;
import com.cb.services.dbService.iDbService.ShopDBService;
import com.cb.services.mapService.iMapService.ShopService;
import com.cb.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    ShopDBService shopDBService;
    @Autowired
    DefaultDTO defaultDTO;

    public DefaultDTO getWeapons() {
        try {
            List<WeaponsDAL> weaponsListDAL = shopDBService.getWeapons();
            List<ShopBL> weaponsListBL = ObjectMapperUtils.mapAll(weaponsListDAL, ShopBL.class);
            defaultDTO.setSuccess(true);
            defaultDTO.setData(weaponsListBL);
        } catch (Exception e){
            defaultDTO.setSuccess(false);
            defaultDTO.setMessage("General error: " + e.getMessage());
        }
        return defaultDTO;
    }
}
