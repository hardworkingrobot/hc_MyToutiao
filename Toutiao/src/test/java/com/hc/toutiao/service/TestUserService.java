package com.hc.toutiao.service;

import com.hc.toutiao.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class TestUserService {

    @Autowired
    UserService userService;

    @Test
    public void getUserByUserService(){
        User u = userService.getUser(2);
        System.out.println(u);
    }

    @Test
    public void balance2UsersTest(){
        User user1 = userService.getUser(1);
        User user2 = userService.getUser(2);
        userService.balance2Users(user1,user2,10000);
    }
}
