package com.compass.controller;

import com.compass.service.AddService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.*;

@Controller
public class AddController {
    ModelAndView mv = new ModelAndView();

    @RequestMapping("/add")
    public ModelAndView add(@RequestParam("name") String name,@RequestParam("alias") String alias,
                            @RequestParam("gender") String gender, @RequestParam("email") String email,
                            String followersCount, HttpServletRequest request, HttpServletResponse response){

        followersCount = request.getParameter("followers")+request.getParameter("scale");

        AddService as = new AddService();
        mv = as.mainService(name,alias,gender,email,followersCount);
        return mv;
    }
}