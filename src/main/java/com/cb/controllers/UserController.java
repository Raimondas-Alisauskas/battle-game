package com.cb.controllers;

import com.cb.beans.UserBean;
import com.cb.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserDao userDao;

    @RequestMapping ("/usersTable")
    public String getUsersTable(Model m){
        List<UserBean> usersList = userDao.getUsers();
        m.addAttribute("usersList", usersList);
        return "usersTable";
    }

    @RequestMapping ("/insertUser")
    public String insertUser(@ModelAttribute("user") UserBean user){
        userDao.insertUser(user);
        return "usersTable";
    }

}
