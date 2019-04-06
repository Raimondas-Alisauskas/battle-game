package com.cb.services.DBService.DBServiceImpl;

import com.cb.dal.CharacterDAL;
import com.cb.services.DBService.IDBService.CharacterDBService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CharacterDBServiceImpl implements CharacterDBService {

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<CharacterDAL> getCharacters() {

        return template.query("SELECT * FROM main.character", new RowMapper<CharacterDAL>() {
            @Override
            public CharacterDAL mapRow(ResultSet rs, int rowNum) throws SQLException {
                CharacterDAL c = new CharacterDAL();
                c.setName(rs.getString(2));
                return c;

            }
        });

    }
}
