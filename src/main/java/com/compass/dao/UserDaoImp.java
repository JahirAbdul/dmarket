package com.compass.dao;

import com.compass.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;
    @Transactional
    public String save(User user) {
        try {
            sessionFactory.getCurrentSession().save(user);
        }
        catch (Exception e)
        {
            System.out.println("Exception");
            e.printStackTrace();
            return "index";
        }

        return "display";
    }

    @Transactional
    public List<User> list() {
        TypedQuery<User> querry= sessionFactory.getCurrentSession().createQuery("from User");
        return (List<User>) querry;
    }
}
