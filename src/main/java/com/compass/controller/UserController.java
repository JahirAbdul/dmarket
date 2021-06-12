package com.compass.controller;

import com.compass.model.User;
import com.compass.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class UserController {
//    ModelAndView mv = new ModelAndView();

    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    public String add(@RequestParam("userName") String userName, @RequestParam("password") String password) {

        String result = userService.save(new User(userName,password));
        return result;
    }





/*
    @RequestMapping("/add")
    public String add(@RequestParam("name") String name,@RequestParam("alias") String alias,
                            @RequestParam("gender") String gender, @RequestParam("email") String email,
                            String followersCount, HttpServletRequest request, HttpServletResponse response){
        followersCount = request.getParameter("followers")+request.getParameter("scale");

        String result = as.mainService(name,alias,gender,email,followersCount);
        return result;
*/

/*

    @ModelAttribute("user")
    public User formBackingObject() {
        return new User();
    }
    @PostMapping("/add")
    public String add(@ModelAttribute("user") @Valid User user, BindingResult result, Model model){

        if (result.hasErrors()) {
            model.addAttribute("users", userService.list());
            return "/";
        }

        userService.save(user);
        return "display";
    }*/
}