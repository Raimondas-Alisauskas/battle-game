package com.cb.controllers;

import com.cb.beans.UserBean;
import com.cb.dao.IDao.UserDao;
import com.cb.service.IService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserDao userDao;


    @RequestMapping ("/userstable")
    public String getUsersTable(Model m){
        List<UserBean> usersList = userService.getUsers();
        m.addAttribute("usersList", usersList);
        return "usersTable";
    }

    /*Displays a form to input data, here "command" is a reserved request attribute
     *which is used to display object data into form */
    @RequestMapping("/newuserform")
    public String showform(Model m){
        m.addAttribute("command", new UserBean());
        return "userForm";
    }

    /*Inserts object into database. The @ModelAttribute puts request data
     *  into model object. */
    @RequestMapping(value="/insert", method = RequestMethod.POST)
    public String insertUser(@ModelAttribute("userBean") UserBean userBean) {
        userService.insertUser(userBean);
        return "redirect:/userstable";
    }

    /* Displays object data into form for the given id.
     * The @PathVariable puts URL data into variable.*/
    @RequestMapping(value="/edituser/{id}")
    public String getUserById(@PathVariable int id, Model m) {
        m.addAttribute("command", userService.getUserById(id));
        return "userForm";
    }

//    /*Updates object into database. The @ModelAttribute puts request data
//     *  into model object. */
//    @RequestMapping(value="/update", method = RequestMethod.POST)
//    public String update(@ModelAttribute("userBean") UserBean userBean) {
//        userDao.updateUser(userBean);
//        return "redirect:/userstable";
//    }

}
