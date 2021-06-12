package com.compass.dao;

import com.compass.model.User;

import java.util.List;

public interface UserDao {

    String save(User user);
    List<User> list();

}
