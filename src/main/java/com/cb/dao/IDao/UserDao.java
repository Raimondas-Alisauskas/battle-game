package com.cb.dao.IDao;

import com.cb.beans.UserBean;

import java.util.List;

public interface UserDao {

    List<UserBean> getUsers();

    int insertUser(UserBean userBean);

    List<UserBean> getUserByEmail(String email);

    UserBean getUserById(int id);

    int updateUser(UserBean userBean);

    int deleteUserById(int id);
}