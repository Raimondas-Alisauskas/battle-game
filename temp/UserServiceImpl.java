package com.cb.services.pageService.viewService;

import com.cb.beans.UserBean;
import com.cb.dbService.iDbService.UserDao;
import com.cb.services.pageService.IService.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<UserBean> getUsers(){
        return userDao.getUsers();
    }

    @Override
    public int insertNewUser(){
        UserBean userBean = new UserBean();
        userBean.setUserName("Name");
        userBean.setPassword("Password");
        userBean.setAdmin(0);
        userBean.setRating(50);
        userBean.setMoney(100);
        userBean.setCharacterId(1);
        userBean.setPartyId(1);
        return userDao.insertUser(userBean);
    }

    @Override
    public int updateUser(UserBean userBean){
        return userDao.updateUser(userBean);
    }

    @Override
    public UserBean getUserById (int id){
        return userDao.getUserById(id);
    }

    @Override
    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }


}
