package com.spring.boot.coffeine.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController extends BaseController{
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @GetMapping
    public String home(Model model){
        model.addAttribute("helloword", "Hello, World, I am Spring Boot");
        return "pages/hone";
    }
}
