package com.cb.services.dbService.dbServiceImpl;

import com.cb.bl.UserBL;
import com.cb.dal.UserDAL;
import com.cb.services.dbService.iDbService.UserDBService;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
    public int insertUser(UserBL u) {
        String sql = "INSERT INTO users(userName, password, email, isAdmin) " +
                "VALUES ('" + u.getUserName() + "','" + u.getPassword() + "','" + u.getEmail() + "'," + u.getIsAdmin() + ")";
        return template.update(sql);
    }


    @Override
    public UserDAL getUserById(int id) {
        String sql = "select * from users where id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(UserDAL.class));
    }

    public String getUserNameById(int userId) {

        return template.queryForObject("SELECT userName from users where id = '" + userId + "'", String.class);

    }

    @Override
    public int getUserByEmailAndPassword(UserBL userBL) {
        if (template.queryForObject("select count(*) from users where email = '" +
                userBL.getEmail() + "' AND password = '" + userBL.getPassword() + "'", Integer.class).equals(1)) {
            return template.queryForObject("select count(*) from users where email = '" + userBL.getEmail() + "' AND password = '" + userBL.getPassword() + "'", Integer.class);
        } else {
            return -1;
        }
    }

    @Override
    public int getUserByEmail(UserBL userBL) {
        if (template.queryForObject("select count(*) from users where email = '" + userBL.getEmail() + "'", Integer.class).equals(1)) {
            return template.queryForObject("select count(*) from users where email = '" + userBL.getEmail() + "'", Integer.class);
        } else {
            return -1;
        }
    }

    @Override
    public String getUserNameByEmail(UserBL userBL) {
        return template.queryForObject("select userName from users where email = '" + userBL.getEmail() + "'", String.class);
    }

    public int getUserIdByEmail(UserBL userBL) {

        return template.queryForObject("select id from users where email = '" + userBL.getEmail() + "'", Integer.class);

    }


    @Override
    public int updateUser(UserBL u) {
        String sql = "UPDATE users SET userName = '" + u.getUserName() + "', password = '" + u.getPassword() + "', isAdmin = " + u.getIsAdmin() + "," +
                "rating = " + "WHERE id = " + u.getId() + "";
        return template.update(sql);
    }

    @Override
    public int deleteUserById(int id) {
        String sql = "DELETE FROM users WHERE id=" + id + "";
        return template.update(sql);
    }

}
