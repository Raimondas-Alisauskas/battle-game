package com.cb.services.dbService.dbServiceImpl;

import com.cb.bl.FighterBL;
import com.cb.dal.WeaponsDAL;
import com.cb.services.dbService.iDbService.ShopDBService;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ShopDBServiceImpl implements ShopDBService {

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) { this.template = template;
    }
    @Override
    public List<WeaponsDAL> getWeapons() {
        return template.query("SELECT * FROM weapons", new BeanPropertyRowMapper<>(WeaponsDAL.class));
    }

}
