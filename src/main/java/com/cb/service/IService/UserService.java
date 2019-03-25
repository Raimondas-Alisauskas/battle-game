package com.cb.service.IService;

import com.cb.beans.UserBean;

import java.util.List;

public interface UserService {


    List<UserBean> getUsers();

    int insertUser(UserBean userBean);

    UserBean getUserById (int id);


}
