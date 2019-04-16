package com.cb.services.dbService.dbServiceImpl;

import com.cb.bl.UserBL;
import com.cb.dal.UserDAL;
import com.cb.services.dbService.iDbService.UserDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDBServiceImpl implements UserDBService {

    JdbcTemplate template;


    @Autowired
    DataSource dataSource;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public List<String> getField(){
        List<String> weapons = new ArrayList<>();
        try(Connection conn = dataSource.getConnection()){
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM weapons");
            while(rs.next()){
                weapons.add(rs.getString("name"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return weapons;
    }


    @Override
    public List<UserDAL> getUsers() {
        return template.query("SELECT * FROM users", new BeanPropertyRowMapper<>(UserDAL.class));
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
    @Override
    public int getUserByEmailAndPassword(UserBL userBL) {
        if(template.queryForObject("select count(*) from users where email = '" +
           userBL.getEmail() + "' AND password = '" + userBL.getPassword() + "'",Integer.class).equals(1)){
           return template.queryForObject("select count(*) from users where email = '" + userBL.getEmail() + "' AND password = '" + userBL.getPassword() + "'",Integer.class);
        }
        else {
            return -1;
        }
    }

    @Override
    public int getUserByEmail(UserBL userBL) {
        if(template.queryForObject("select count(*) from users where email = '" + userBL.getEmail() + "'",Integer.class).equals(1)){
            return template.queryForObject("select count(*) from users where email = '" + userBL.getEmail() + "'",Integer.class);
        }
        else{
            return -1;
        }
    }

    @Override
    public String getUserNameByEmail(UserBL userBL){
        return template.queryForObject("select userName from users where email = '" + userBL.getEmail() + "'",String.class);
    }


    @Override
    public int updateUser(UserBL u) {
        String sql = "UPDATE users SET userName = '" + u.getUserName() + "', password = '" + u.getPassword() + "', isAdmin = " + u.getIsAdmin() + "," + "WHERE id = " + u.getId() + "";
        return template.update(sql);
    }

    @Override
    public int deleteUserById(int id) {
        String sql = "DELETE FROM users WHERE id=" + id + "";
        return template.update(sql);
    }

}
