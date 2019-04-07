package com.cb.services.dbService.iDbService;

import com.cb.dal.UserDAL;

import java.sql.SQLException;
import java.util.List;

public interface UserDBService {

    List<UserDAL> getUsers();

    int insertUser(UserDAL userDAL);

    List<UserDAL> getUserByEmail(String email);

    UserDAL getUserById(int id);

    int updateUser(UserDAL userDAL);

    int deleteUserById(int id);
}
