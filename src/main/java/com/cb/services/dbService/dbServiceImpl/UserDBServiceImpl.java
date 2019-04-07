package com.cb.services.dbService.dbServiceImpl;

import com.cb.dal.UserDAL;
import com.cb.services.dbService.iDbService.UserDBService;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDBServiceImpl implements UserDBService {

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<UserDAL> getUsers() {
        return template.query("SELECT * FROM users", new BeanPropertyRowMapper(UserDAL.class));
    }

    @Override
    public int insertUser(UserDAL u) {
        String sql = "INSERT INTO users(userName, password, email, isAdmin, rating, money, characterId, partyId) " +
                "VALUES ('" + u.getUserName() + "','" + u.getPassword() + "','" + u.getEmail() + "'," + u.getAdmin() + "," + u.getRating() + "," + u.getMoney() + ","
                + u.getCharacterId() + "," + u.getPartyId() + ")";
        return template.update(sql);
    }

    @Override
    public List<UserDAL> getUserByEmail(String email) {

        return template.query("SELECT * FROM users where email = '" + email + "'", new RowMapper<UserDAL>() {
            @Override
            public UserDAL mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserDAL u = new UserDAL();
                u.setEmail(rs.getString(4));
                return u;
            }
        });

    }

    @Override
    public UserDAL getUserById(int id) {
        String sql = "select * from users where id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(UserDAL.class));
    }

    @Override
    public int updateUser(UserDAL u) {
        String sql = "UPDATE users SET userName = '" + u.getUserName() + "', password = '" + u.getPassword() + "', isAdmin = " + u.getAdmin() + "," +
                "rating = " + u.getRating() + ", money = " + u.getMoney() + ", characterId = " + u.getCharacterId() + ", partyId = " + u.getPartyId() + " " +
                "WHERE id = " + u.getId() + "";
        return template.update(sql);
    }

    @Override
    public int deleteUserById(int id) {
        String sql = "DELETE FROM users WHERE id=" + id + "";
        return template.update(sql);
    }

}
