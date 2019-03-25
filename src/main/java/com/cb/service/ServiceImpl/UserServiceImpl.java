package com.cb.service.ServiceImpl;

import com.cb.beans.UserBean;
import com.cb.dao.IDao.UserDao;
import com.cb.service.IService.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {
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
