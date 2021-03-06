package com.cb.services.mapService.iMapService;

import com.cb.bl.UserBL;
import com.cb.dto.DefaultDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    DefaultDTO getUsers();

    DefaultDTO insertNewUser(UserBL userBL);

    DefaultDTO insertNewUser();

    int registerUser(UserBL userBL);

    int getUserByEmail(UserBL userBL);

    DefaultDTO updateUser(UserBL userBL);

    DefaultDTO getUserById(int id);

    String getUserNameByEmail(UserBL userBL);

    int getUserIdByEmail(UserBL userBL);

    DefaultDTO deleteUserById(int id);

    int getUserByEmailAndPassword(UserBL userBL);

    String getUserNameById(int userId);
}
