package com.cb.services.dbService.dbServiceImpl;

import com.cb.dal.FightCallsDAL;
import com.cb.services.dbService.iDbService.FightCallsDBService;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class FightCallsDBServiceImpl implements FightCallsDBService {

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public List<FightCallsDAL> getFightCalls() {

        return template.query("SELECT * FROM fight_calls", new BeanPropertyRowMapper(FightCallsDAL.class));

    }

    public int isFighterCalled(int fighterId, int calledFighterId) {

        return template.queryForObject("SELECT count(*) FROM fight_calls where callingFighter = "
                + fighterId + " AND calledFighter = " + calledFighterId + " AND onFight = " + false, Integer.class);

    }

    public int insertFightCall(int fighterId, int calledFighterId) {

        return template.update("INSERT INTO fight_calls (callingFighter, calledFighter, onFight)" +
                " VALUES (" + fighterId + ", " + calledFighterId + "," + false + ")");

    }

    public List<FightCallsDAL> getCallingFighterId(int fighterId) {

        return template.query("SELECT callingFighter from fight_calls where calledFighter = " + fighterId + " AND onFight = " + false, new BeanPropertyRowMapper(FightCallsDAL.class));

    }

}
