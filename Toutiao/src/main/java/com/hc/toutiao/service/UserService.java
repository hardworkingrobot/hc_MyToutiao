package com.hc.toutiao.service;

import com.hc.toutiao.pojo.User;

public interface UserService {
    public void balance2Users(User user1, User user2, float amount);
    public User getUser(int id);
}
