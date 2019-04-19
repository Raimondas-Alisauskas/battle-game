package com.cb.services.dbService.dbServiceImpl;

import com.cb.bl.FighterBL;
import com.cb.dal.PartyDAL;
import com.cb.services.dbService.iDbService.PartyDBService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PartyDBServiceImpl implements PartyDBService {

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<PartyDAL> getParties() {

        return template.query("SELECT * FROM party", new RowMapper<PartyDAL>() {
            @Override
            public PartyDAL mapRow(ResultSet rs, int rowNum) throws SQLException {
                PartyDAL c = new PartyDAL();
                c.setName(rs.getString(2));
                return c;
            }
        });
    }

    public int getPartyId(FighterBL fighterBL) {

        return template.queryForObject("SELECT Id from party where Name = '" + fighterBL.getParty() + "'", Integer.class);

    }

    public String getPartyName(int partyId) {

        return template.queryForObject("SELECT Name from party where Id = '" + partyId + "'", String.class);

    }

}

