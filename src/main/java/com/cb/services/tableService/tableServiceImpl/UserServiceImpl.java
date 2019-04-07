package com.cb.services.tableService.tableServiceImpl;

import com.cb.bl.UserBL;
import com.cb.dal.UserDAL;
import com.cb.services.dbService.iDbService.UserDBService;
import com.cb.dto.DefaultDTO;

import com.cb.services.tableService.iTableService.UserService;
import com.cb.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDBService userDBService;
    @Autowired
    DefaultDTO defaultDTO;

    public DefaultDTO getUsers() {
        try {
            List<UserDAL> usersListDAL = userDBService.getUsers();
            List<UserBL> usersListBL = ObjectMapperUtils.mapAll(usersListDAL, UserBL.class);
            defaultDTO.setSuccess(true);
            defaultDTO.setData(usersListBL);
        } catch (SQLException e) {
            defaultDTO.setSuccess(false);
            defaultDTO.setMessage("Error during an interaction with a data source: " + e.getMessage());
        } catch (Exception e){
            defaultDTO.setSuccess(false);
            defaultDTO.setMessage("General error: " + e.getMessage());
        }
        return defaultDTO;
    }

    public int insertNewUser(UserDAL userDAL) {
        return userDBService.insertUser(userDAL);
    }

    public int insertNewUser() {
        UserDAL userDAL = new UserDAL();
        userDAL.setUserName("Name");
        userDAL.setPassword("Password");
        userDAL.setEmail("email");
        userDAL.setAdmin(0);
        userDAL.setRating(50);
        userDAL.setMoney(100);
        userDAL.setCharacterId(1);
        userDAL.setPartyId(1);
        return userDBService.insertUser(userDAL);
    }

    public int registerUser(UserDAL userDAL) {

        userDAL.setAdmin(0);
        userDAL.setRating(100);
        userDAL.setMoney(1000);
        userDAL.setCharacterId(1);
        userDAL.setPartyId(1);

        return userDBService.insertUser(userDAL);

    }

    public List<UserDAL> getUserByEmail(String email) {
        return userDBService.getUserByEmail(email);
    }

    public int updateUser(UserDAL userDAL) {
        return userDBService.updateUser(userDAL);
    }

    public UserDAL getUserById(int id) {
        return userDBService.getUserById(id);
    }

    public void deleteUserById(int id) {
        userDBService.deleteUserById(id);
    }

}
