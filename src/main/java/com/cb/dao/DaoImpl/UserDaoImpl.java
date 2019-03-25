package com.cb.dao.DaoImpl;

import com.cb.beans.UserBean;
import com.cb.dao.IDao.UserDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

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

    public int insertUser(UserBean u) {
        String sql = "INSERT INTO users(userName, password, isAdmin, rating, money, characterId, partyId) " +
            "VALUES ('"+u.getUserName()+"','"+u.getPassword()+"',"+u.getAdmin()+","+u.getRating()+","+u.getMoney()+","
            +u.getCharacterId()+","+u.getPartyId()+")";
        return template.update(sql);
    }

    public UserBean getUserById(int id) {
        String sql="select * from users where id=?";
        return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<>(UserBean.class));
    }

    public int updateUser(UserBean u) {
        String sql = "UPDATE users SET userName = '"+u.getUserName()+"', password = '"+u.getPassword()+"', isAdmin = "+u.getAdmin()+"," +
            "rating = "+u.getRating()+", money = "+u.getMoney()+", characterId = "+u.getCharacterId()+", partyId = "+u.getPartyId()+" " +
            "WHERE id = "+u.getId()+"";
    return template.update(sql);
    }

}
