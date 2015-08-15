package com.springapp.mvc.controller;

import com.notebook.app.domain.User;
import com.notebook.app.services.UserService;
import com.notebook.app.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by user on 8/14/2015.
 */
@Controller
@RequestMapping()
public class UserController
{

   @Autowired
 //@Qualifier("userService")
    UserService userService;

    @RequestMapping(value = "/user" ,method = RequestMethod.GET)
    public ModelAndView getUserList()
    {
        List userList = userService.getList();
        return new ModelAndView("userslist", "userList", userList);
    }


    @RequestMapping(value = "adduser", method = RequestMethod.POST)
    public String addUser(@RequestParam("name") String name, @RequestParam("password") String password)
    {
        User user = new User();
        user.setName(name);
        user.setPassword(password);

        userService.insertRow(user);
        return "user-form";
    }



}
