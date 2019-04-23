package com.cb.services.mapService.mapServiceImpl;

import com.cb.bl.UserBL;
import com.cb.dal.UserDAL;
import com.cb.services.dbService.iDbService.UserDBService;
import com.cb.dto.DefaultDTO;

import com.cb.services.mapService.iMapService.UserService;
import com.cb.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        userBL.setIsAdmin(false);
        return insertNewUser(userBL);
    }

    public int registerUser(UserBL userBL) {

        userBL.setIsAdmin(false);

        return userDBService.insertUser(userBL);

    }

    public int getUserByEmail(UserBL userBL) {
        return userDBService.getUserByEmail(userBL);
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

    @Override
    public String getUserNameByEmail(UserBL userBL) {
        return userDBService.getUserNameByEmail(userBL);
    }

    public int getUserIdByEmail(UserBL userBL) {

        return userDBService.getUserIdByEmail(userBL);

    }

    public DefaultDTO deleteUserById(int id) {
        try{
            int result = userDBService.deleteUserById(id);
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

    @Override
    public int getUserByEmailAndPassword(UserBL userBL) {
        return userDBService.getUserByEmailAndPassword(userBL);
    }

    public String getUserNameById(int userId) {

        return userDBService.getUserNameById(userId);

    }

}
