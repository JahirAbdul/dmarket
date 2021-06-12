package com.compass.service;

import com.compass.model.User;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

        String save(User user);

        List<User> list();
    /*public String mainService(String name,String alias,String gender,String email,String followersCount){
        //Temporary Test to add elements
        User user = new User();
        user.setUserName(name);
        user.setPassword(alias);
        save(user);
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("display");
        return "display";*/

}
