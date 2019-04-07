package com.cb.services.tableService.iTableService;

import com.cb.bl.UserBL;
import com.cb.dal.UserDAL;
import com.cb.dto.DefaultDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    DefaultDTO getUsers();

    DefaultDTO insertNewUser(UserBL userBL);

    DefaultDTO insertNewUser();

    int registerUser(UserBL userBL);

    List<UserDAL> getUserByEmail(String email);

    DefaultDTO updateUser(UserBL userBL);

    DefaultDTO getUserById(int id);

    DefaultDTO deleteUserById(int id);

}
