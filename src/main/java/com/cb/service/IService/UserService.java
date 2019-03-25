package com.cb.service.IService;

import com.cb.beans.UserBean;
import com.cb.dao.IDao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {
    @Autowired
    UserDao userDao;

    public List<UserBean> getUsers(){
        return userDao.getUsers();
    }

    public int insertUser(UserBean userBean){
        return userDao.insertUser(userBean);
    }

    public UserBean getUserById (int id){
        return userDao.getUserById(id);
    }


}
