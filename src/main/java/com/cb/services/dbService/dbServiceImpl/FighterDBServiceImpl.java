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

        return template.queryForObject("SELECT count(*) from fighters where userId = '" + userId + "'", Integer.class);

    }

    public List<FighterDAL> getFighters(int fighterId) {
        return template.query("SELECT * FROM fighters where id != " + fighterId, new BeanPropertyRowMapper(FighterDAL.class));
//        return template.query("SELECT * FROM fighters where id != (" + fighterId +" AND (SELECT callingFighter FROM fight_calls WHERE (callingFighter = " + fighterId + " AND onFight = true) OR (calledFighter = " + fighterId + " AND onFight = true) AND (SELECT calledFighter FROM fight_calls WHERE (callingFighter = " + fighterId + " AND onFight = true) OR (calledFighter = " + fighterId + " AND onFight = true)))", new BeanPropertyRowMapper(FighterDAL.class));

    }

    public FighterDAL getFighterByUserId(int userId) {
        String sql = "select * from fighters where userId =?";
        return template.queryForObject(sql, new Object[]{userId}, new BeanPropertyRowMapper<>(FighterDAL.class));
    }

    public int getFighterIdByUserId(int userId) {
        return template.queryForObject("SELECT id FROM fighters where userId = '" + userId + "'", Integer.class);
    }

    public FighterDAL getFighterByFighterId(int fighterId) {
        String sql = "select * from fighters where id =?";
        return template.queryForObject(sql, new Object[]{fighterId}, new BeanPropertyRowMapper<>(FighterDAL.class));
    }

}
