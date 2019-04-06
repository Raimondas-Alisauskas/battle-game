package com.cb.services.tableService.iTableService;

import com.cb.dal.UserDAL;
import com.cb.dto.DefaultDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    DefaultDTO getUsers();

    int insertNewUser(UserDAL userDAL);

    int insertNewUser();

    int registerUser(UserDAL userDAL);

    List<UserDAL> getUserByEmail(String email);

    int updateUser(UserDAL userDAL);

    UserDAL getUserById(int id);

    void deleteUserById(int id);

}
