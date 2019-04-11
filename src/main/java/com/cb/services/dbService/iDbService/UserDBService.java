package com.cb.services.dbService.iDbService;

import com.cb.bl.UserBL;
import com.cb.dal.UserDAL;

import java.util.List;

public interface UserDBService {

    List<UserDAL> getUsers();

    int insertUser(UserBL userBL);

    int getUserByEmail(UserBL userBL);

    String getUserNameByEmail(UserBL userBL);

    int getUserByEmailAndPassword(UserBL userBL);

    UserDAL getUserById(int id);

    int updateUser(UserBL userBL);

    int deleteUserById(int id);
}
