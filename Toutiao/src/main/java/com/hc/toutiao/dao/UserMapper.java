package com.hc.toutiao.dao;

import com.hc.toutiao.pojo.User;

import java.util.List;

public interface UserMapper {
    void save(User user);
    void update(User user);
    void delete(int id);
    User findById(int id);
    List<User> findAll();

}
