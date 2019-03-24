package com.cb.dao;

import com.cb.beans.UserBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao {
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public List<UserBean> getUsers() {
        return  template.query("SELECT * FROM users", new RowMapper<UserBean>() {
            @Override
            public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserBean u = new UserBean();
                u.setId(rs.getInt(1));
                u.setUserName(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setAdmin(rs.getByte(4));
                u.setRating(rs.getInt(5));
                u.setMoney(rs.getInt(6));
                u.setCharacterId(rs.getInt(7));
                u.setPartyId(rs.getInt(8));
                return u;
            }
        });
    }

    public int editUser(UserBean u) {
        String sql = "INSERT INTO users(name, password, isAdmin, rating, money, characterId, partyId) " +
                     "VALUES ('"+u.getUserName()+"','"+u.getPassword()+"',"+u.getAdmin()+","+u.getRating()+","+u.getMoney()+","+u.getCharacterId()+","+u.getPartyId()+")" +
                "WHERE id = "+u.getId()+"";
        return template.update(sql);

    }

    public int insertUser(UserBean u) {
        String sql = "INSERT INTO users(name, password, isAdmin, rating, money, characterId, partyId) " +
                "VALUES ('"+u.getUserName()+"','"+u.getPassword()+"',"+u.getAdmin()+","+u.getRating()+","+u.getMoney()+","+u.getCharacterId()+","+u.getPartyId()+")";
        return template.update(sql);
    }



}
