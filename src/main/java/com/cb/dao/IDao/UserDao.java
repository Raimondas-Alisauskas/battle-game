package com.cb.dao.IDao;

import com.cb.beans.UserBean;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface UserDao {

    List<UserBean> getUsers();

    int insertUser(UserBean userBean);

    List<UserBean> getUserByEmail(String email);

    UserBean getUserById(int id);

    List<UserBean> getUserByPassword(String password);

    int updateUser(UserBean userBean);

    int deleteUserById(int id);
}
