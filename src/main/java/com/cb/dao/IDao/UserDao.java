package com.cb.dao.IDao;

import com.cb.beans.UserBean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface UserDao {

    List<UserBean> getUsers();

    int insertUser(UserBean u);

    UserBean getUserById(int id);

    int updateUser(UserBean u);

}
