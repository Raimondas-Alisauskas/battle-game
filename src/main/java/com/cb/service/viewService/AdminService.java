package com.cb.service.viewService;

import com.cb.bl.UserBL;
import com.cb.dto.DefaultDTO;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AdminService {
    @Autowired
    UserService userService;

    public DefaultDTO getUsers(){

        DefaultDTO defaultDTOin = userService.getUsers();
        DefaultDTO defaultDTOout = defaultDTOin;

        //TODO Automapping
        List<UserBL> usersListBL = (List<UserBL>) defaultDTOin.getData();
        defaultDTOout.setData(usersListBL);

        return defaultDTOout;
    }
}
