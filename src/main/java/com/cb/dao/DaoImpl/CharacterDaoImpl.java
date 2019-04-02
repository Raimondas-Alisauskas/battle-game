package com.cb.dao.DaoImpl;

import com.cb.beans.CharacterBean;
import com.cb.dao.IDao.CharacterDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CharacterDaoImpl implements CharacterDao {

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<CharacterBean> getParties() {

        return template.query("SELECT * FROM character", new RowMapper<CharacterBean>() {
            @Override
            public CharacterBean mapRow(ResultSet rs, int rowNum) throws SQLException {
                CharacterBean c = new CharacterBean();
                c.setName(rs.getString(2));
                c.setImage(rs.getBlob(3));
                return c;
            }
        });
    }

}

