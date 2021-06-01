package com.compass.service;

import org.springframework.web.servlet.ModelAndView;

public class AddService {

    public ModelAndView mainService(String name,String alias,String gender,String email,String followersCount){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("display");
        mv.addObject("name",name.trim());
        mv.addObject("alias",alias.trim());
        mv.addObject("gender",gender.trim());
        mv.addObject("email",email.trim());
        mv.addObject("followersCount",followersCount);
        return mv;

    }

}
