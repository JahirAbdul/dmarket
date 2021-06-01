package com.compass.controller;

import com.compass.service.UploadFileService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class FileUploadController {
    ModelAndView mv = new ModelAndView();

    @RequestMapping("/upload")
    public ModelAndView upload(@RequestParam("file") MultipartFile file) {
        System.out.println("File Name is : " + file.getOriginalFilename());
        mv.setViewName("uploadStatus");

        UploadFileService ufs = new UploadFileService();
        ufs.upload(file,mv);
        return mv;
    }
}
