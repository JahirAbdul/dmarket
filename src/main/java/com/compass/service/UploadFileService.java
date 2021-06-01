package com.compass.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;

public class UploadFileService {
    private static String UPLOADED_FOLDER = "D:\\Geek\\tomcat-10\\dmarket(upload file)";
    /*public ModelAndView upload(MultipartFile file, ModelAndView mv){
        System.out.println("Here");
        if (file.isEmpty()) {
            mv.addObject("message","Please select a file to upload");
            //redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return mv;
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
//            Files.createFile(path, (FileAttribute<?>) file);
            Files.write(path, bytes);
            System.out.println(Files.exists(path));
            mv.addObject("message","You successfully uploaded '" + file.getOriginalFilename() + "'");

//            redirectAttributes.addFlashAttribute("message","You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return mv;
    }*/
    public ModelAndView upload(MultipartFile file, ModelAndView mv) {
        Logger logger = LoggerFactory.getLogger("SampleLogger");
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "dmarket(upload file)");
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + file.getOriginalFilename());
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                logger.info("Server File Location : {}",serverFile.getAbsolutePath());

                mv.addObject("message", "You successfully uploaded file=" + file.getOriginalFilename());
                return mv;
            } catch (Exception e) {
                mv.addObject("message", "You failed to upload " + file.getOriginalFilename() );
                e.printStackTrace();
                return mv;
                //return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
                mv.addObject("message","Please select a file to upload");
                return mv;
        }

    }
}
