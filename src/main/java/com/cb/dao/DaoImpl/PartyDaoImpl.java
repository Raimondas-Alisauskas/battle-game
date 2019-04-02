package com.cb.dao.DaoImpl;

import com.cb.beans.CharacterBean;
import com.cb.beans.PartyBean;
import com.cb.dao.IDao.PartyDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PartyDaoImpl implements PartyDao {

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<PartyBean> getParties() {

        return template.query("SELECT * FROM party", new RowMapper<PartyBean>() {
            @Override
            public PartyBean mapRow(ResultSet rs, int rowNum) throws SQLException {
                PartyBean c = new PartyBean();
                c.setName(rs.getString(2));
                return c;
            }
        });
    }

}

