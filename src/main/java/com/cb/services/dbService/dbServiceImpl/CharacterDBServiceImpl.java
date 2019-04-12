package com.cb.services.dbService.dbServiceImpl;

import com.cb.dal.CharacterDAL;
import com.cb.dal.UserDAL;
import com.cb.services.dbService.iDbService.CharacterDBService;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.awt.*;
import java.sql.Blob;
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

        return template.query("SELECT * FROM main.character", new BeanPropertyRowMapper(CharacterDAL.class));

    }

}
