package com.cb.services.service.ServiceImpl;

import com.cb.bl.UserBL;
import com.cb.dal.UserDAL;
import com.cb.services.DBService.IDBService.UserDBService;
import com.cb.dto.DefaultDTO;

import com.cb.services.service.IService.UserService;
import com.cb.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDBService userDBService;

    public DefaultDTO getUsers() {
        List<UserDAL> usersListDAL = userDBService.getUsers();

        List<UserBL> usersListBL = ObjectMapperUtils.mapAll(usersListDAL, UserBL.class);

        DefaultDTO defaultDTO = new DefaultDTO();
        if (usersListDAL.size() != 0) {
            defaultDTO.setSuccess(true);
            defaultDTO.setData(usersListBL);
        } else {
            defaultDTO.setSuccess(false);
            defaultDTO.setMessage("No data");
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
