package com.cb.dao.IDao;

import com.cb.beans.UserBean;
import com.cb.dto.DefaultDTO;

import java.util.List;

public interface UserDao {

    DefaultDTO getUsers();

    int insertUser(UserBean userBean);

    List<UserBean> getUserByEmail(String email);

    UserBean getUserById(int id);

    int updateUser(UserBean userBean);

    int deleteUserById(int id);
}
