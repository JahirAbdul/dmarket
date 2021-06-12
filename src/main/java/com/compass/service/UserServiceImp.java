package com.compass.service;

import com.compass.dao.UserDao;
import com.compass.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public String save(User user) {
        String result = userDao.save(user);
        return result;
    }

    @Transactional
    public List<User> list() {
        return userDao.list();
    }


}
