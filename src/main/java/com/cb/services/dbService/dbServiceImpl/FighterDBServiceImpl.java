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
        String sql = "INSERT INTO fighters(userId, characterId, partyId, money, rating) " +
                "VALUES ('" + fighterBL.getUserId() + "','" + fighterBL.getCharacterId() + "','" + fighterBL.getPartyId() + "','"
                + fighterBL.getMoney() + "'," + fighterBL.getRating() + ")";
        return template.update(sql);
    }

    public int getFighterCountByUserId(int userId) {

        return template.queryForObject("SELECT count(*) from main.fighters where userId = '" + userId + "'", Integer.class);

    }

    public List<FighterDAL> getFighters() {
        return template.query("SELECT * FROM fighters", new BeanPropertyRowMapper(FighterDAL.class));
    }

    public FighterDAL getFighterByUserId(int userId) {
        String sql = "select * from main.fighters where userId =?";
        return template.queryForObject(sql, new Object[]{userId}, new BeanPropertyRowMapper<>(FighterDAL.class));
    }

}
