package com.compass.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MultipartException.class)
    public ModelAndView handleError1(MultipartException e) {

        ModelAndView mv = new ModelAndView();
        mv.addObject("message",e.getCause().getMessage());
//        redirectAttributes.addFlashAttribute("message", e.getCause().getMessage());
        return mv;

    }
}