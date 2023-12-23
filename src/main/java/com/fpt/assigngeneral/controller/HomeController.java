package com.fpt.assigngeneral.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
  
  @GetMapping(value = "/")
  public ModelAndView getHomePage(){
    ModelAndView mv = new ModelAndView("html/home");
    return mv;
  }
}
