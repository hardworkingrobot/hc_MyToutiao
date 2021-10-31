package com.hc.toutiao.controller;

import com.hc.toutiao.pojo.User;
import com.hc.toutiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUserByUserController(int id){
        System.out.println(id);
        User user = userService.getUser(id);
        return user;
    }

}
