package com.cb.services.dbService.dbServiceImpl;

import com.cb.bl.FighterBL;
import com.cb.dal.FighterDAL;
import com.cb.services.dbService.iDbService.FighterDBService;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class FighterDBServiceImpl implements FighterDBService {

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int insertFighter(FighterBL fighterBL) {
        String sql = "INSERT INTO fighters(userId, characterId, money, rating) " +
                "VALUES ('" + fighterBL.getUserId() + "','" + fighterBL.getCharacterId() + "','" + fighterBL.getMoney() + "'," + fighterBL.getRating() + ")";
        return template.update(sql);
    }

    public List<FighterDAL> getFighters(){
        return template.query("SELECT * FROM users", new BeanPropertyRowMapper(FighterDAL.class));
    }

}
