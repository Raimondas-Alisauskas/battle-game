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
        } catch (Exception e){
            defaultDTO.setSuccess(false);
            defaultDTO.setMessage("General error: " + e.getMessage());
        }
        return defaultDTO;
    }

    public DefaultDTO insertNewUser(UserBL userBL) {
        try{
            int result = userDBService.insertUser(userBL);
            if(result == 1) {
                defaultDTO.setSuccess(true);
                defaultDTO.setData(result);
            } else {
                defaultDTO.setSuccess(false);
                defaultDTO.setMessage("General error: can't insert user" );
            }
        } catch (Exception e){
            defaultDTO.setSuccess(false);
            defaultDTO.setMessage("General error: " + e.getMessage());
        }
        return defaultDTO;
    }

    public DefaultDTO insertNewUser() {
        UserBL userBL = new UserBL();
        userBL.setUserName("Name");
        userBL.setPassword("Password");
        userBL.setEmail("email");
        userBL.setAdmin(0);
        userBL.setRating(50);
        userBL.setMoney(100);
        userBL.setCharacterId(1);
        userBL.setPartyId(1);
        return insertNewUser(userBL);
    }

    public int registerUser(UserBL userBL) {

        userBL.setAdmin(0);
        userBL.setRating(100);
        userBL.setMoney(1000);
        userBL.setCharacterId(1);
        userBL.setPartyId(1);

        return userDBService.insertUser(userBL);

    }

    public List<UserDAL> getUserByEmail(String email) {
        return userDBService.getUserByEmail(email);
    }

    public DefaultDTO updateUser(UserBL userBL) {
        try{
            int result = userDBService.updateUser(userBL);
            if(result == 1) {
                defaultDTO.setSuccess(true);
                defaultDTO.setMessage("User updated");
            } else {
                defaultDTO.setSuccess(false);
                defaultDTO.setMessage("General error: can't update user" );
            }
        } catch (Exception e){
            defaultDTO.setSuccess(false);
            defaultDTO.setMessage("General error: " + e.getMessage());
        }
        return defaultDTO;



    }

    public DefaultDTO getUserById(int id) {
        try{
            UserDAL userDAL = userDBService.getUserById(id);
            UserBL userBL = ObjectMapperUtils.map(userDAL,UserBL.class);
            defaultDTO.setSuccess(true);
            defaultDTO.setData(userBL);
        } catch (Exception e){
            defaultDTO.setSuccess(false);
            defaultDTO.setMessage("General error: " + e.getMessage());
        }
        return defaultDTO;

    }

    public DefaultDTO deleteUserById(int id) {
        try{
            int result = userDBService.deleteUserById(id);;
            if(result == 1) {
                defaultDTO.setSuccess(true);
                defaultDTO.setMessage("User deleted");
            } else {
                defaultDTO.setSuccess(false);
                defaultDTO.setMessage("General error: can't delete user" );
            }
        } catch (Exception e){
            defaultDTO.setSuccess(false);
            defaultDTO.setMessage("General error: " + e.getMessage());
        }
        return defaultDTO;
    }

}
