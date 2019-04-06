package com.cb.services.DBService.IDBService;

import com.cb.dal.UserDAL;

import java.util.List;

public interface UserDBService {

    List<UserDAL> getUsers();

    int insertUser(UserDAL userDAL);

    List<UserDAL> getUserByEmail(String email);

    List<UserDAL> getUserByPassword(String password);

    UserDAL getUserById(int id);

    int updateUser(UserDAL userDAL);

    int deleteUserById(int id);
}
