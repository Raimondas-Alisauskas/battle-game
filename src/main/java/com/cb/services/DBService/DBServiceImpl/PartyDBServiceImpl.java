package com.cb.services.DBService.DBServiceImpl;

import com.cb.dal.PartyDAL;
import com.cb.services.DBService.IDBService.PartyDBService;
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

}

