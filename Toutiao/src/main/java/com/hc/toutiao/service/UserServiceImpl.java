package com.hc.toutiao.service;

import com.hc.toutiao.dao.UserMapper;
import com.hc.toutiao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public void balance2Users(User user1, User user2, float amount) {
        //有两个数据库操作，测试事务执行
        user1.setSalary(user1.getSalary()-amount);
        userMapper.update(user1);

        //增加异常
        //int i = 99/0;

        user2.setSalary(user2.getSalary()-amount);
        userMapper.update(user2);
    }

    @Override
    public User getUser(int id) {
        User user = userMapper.findById(id);
        System.out.println("通过service层获取用户信息!");
        return user;
    }
}
