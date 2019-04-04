package com.cb.service.viewService;

import com.cb.beans.UserBean;
import com.cb.dao.IDao.UserDao;
import com.cb.dto.DefaultDTO;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {

    @Autowired
    UserDao userDao;


    public DefaultDTO getUsers() {
        List<UserBean> usersList =userDao.getUsers();

        DefaultDTO defaultDTO = new DefaultDTO();
        if( usersList.size() != 0){
            defaultDTO.setSuccess(true);
            defaultDTO.setData(usersList);
        } else{
            defaultDTO.setSuccess(false);
            defaultDTO.setMessage("No data");
        }
        return defaultDTO;
    }


    public int insertNewUser(UserBean userBean) {
        return userDao.insertUser(userBean);
    }


    public int insertNewUser(){
        UserBean userBean = new UserBean();
        userBean.setUserName("Name");
        userBean.setPassword("Password");
        userBean.setEmail("email");
        userBean.setAdmin(0);
        userBean.setRating(50);
        userBean.setMoney(100);
        userBean.setCharacterId(1);
        userBean.setPartyId(1);
        return userDao.insertUser(userBean);
    }


    public int registerUser(UserBean userBean) {

        userBean.setAdmin(0);
        userBean.setRating(100);
        userBean.setMoney(1000);
        userBean.setCharacterId(1);
        userBean.setPartyId(1);

        return userDao.insertUser(userBean);

    }


    public List<UserBean> getUserByEmail(String email){ return userDao.getUserByEmail(email); }


    public int updateUser(UserBean userBean) {
        return userDao.updateUser(userBean);
    }


    public UserBean getUserById(int id) {
        return userDao.getUserById(id);
    }


    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }

}
