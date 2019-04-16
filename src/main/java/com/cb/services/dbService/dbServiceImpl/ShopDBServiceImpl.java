package com.cb.services.dbService.dbServiceImpl;

import com.cb.dal.UserDAL;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ShopDBServiceImpl {

    JdbcTemplate template;


    public List<UserDAL> getUsers() {
        return template.query("SELECT * FROM weapons", new BeanPropertyRowMapper<>(UserDAL.class));
    }

}
