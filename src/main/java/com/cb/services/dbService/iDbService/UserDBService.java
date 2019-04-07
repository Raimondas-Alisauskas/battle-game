package com.cb.services.dbService.iDbService;

import com.cb.bl.UserBL;
import com.cb.dal.UserDAL;

import java.sql.SQLException;
import java.util.List;

public interface UserDBService {

    List<UserDAL> getUsers();

    int insertUser(UserBL userBL);

    List<UserDAL> getUserByEmail(String email);

    UserDAL getUserById(int id);

    int updateUser(UserBL userBL);

    int deleteUserById(int id);
}
