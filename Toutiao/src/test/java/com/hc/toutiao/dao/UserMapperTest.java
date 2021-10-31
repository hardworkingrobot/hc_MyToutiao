package com.hc.toutiao.dao;

import com.hc.toutiao.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void saveTest(){
        User user = new User();
        user.setName("孙权");
        user.setBirthday(new Date());
        user.setSalary(3000000);
        userMapper.save(user);
    }

    @Test
    public void findByIdTest(){
        User u = userMapper.findById(2);
        System.out.println(u);
    }

    @Test
    public void findAllTest(){
        List<User> users = userMapper.findAll();
        System.out.println(users);
    }

    @Test
    public void updateTest(){
        User user = userMapper.findById(2);
        user.setSalary(2000000);
        userMapper.update(user);
    }

    @Test
    public void deleteTest(){
        userMapper.delete(3);
    }
}
