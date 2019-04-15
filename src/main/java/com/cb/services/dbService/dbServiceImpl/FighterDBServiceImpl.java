package com.cb.services.dbService.dbServiceImpl;

import com.cb.bl.FighterBL;
import com.cb.services.dbService.iDbService.FighterDBService;
import org.springframework.jdbc.core.JdbcTemplate;

public class FighterDBServiceImpl implements FighterDBService {

    JdbcTemplate template;

    public int insertFighter(FighterBL fighterBL) {
        String sql = "INSERT INTO fighters(userId, characterId, money, rating) " +
                "VALUES ('" + fighterBL.getUserId() + "','" + fighterBL.getCharacterId() + "','" + 1000 + "'," + 1000 + ")";
        return template.update(sql);
    }

}
