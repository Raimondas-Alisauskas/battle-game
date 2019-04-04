package com.cb.service.IService;

import com.cb.beans.UserBean;
import com.cb.dto.DefaultDTO;

import java.util.List;

public interface UserService {

    DefaultDTO getUsers();

    int insertNewUser(UserBean userBean);

    int insertNewUser();

    int registerUser(UserBean userBean);

    List<UserBean> getUserByEmail(String email);

    int updateUser(UserBean userBean);

    UserBean getUserById(int id);

    void deleteUserById(int id);
}
