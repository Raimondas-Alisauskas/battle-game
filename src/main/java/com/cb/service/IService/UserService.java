package com.cb.service.IService;

import com.cb.beans.UserBean;

import java.util.List;

public interface UserService {

    List<UserBean> getUsers();

    int insertNewUser(UserBean userBean);

    int insertNewUser();

    int registerUser(UserBean userBean);

    List<UserBean> getUserByEmail(String email);

    List<UserBean> getUserByPassword(String password);

    int updateUser(UserBean userBean);

    UserBean getUserById(int id);

    void deleteUserById(int id);
}
