package com.example.demo.controllers;

import com.example.demo.service.About;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AboutController {

    private About aboutPage;

    @Autowired
    public AboutController(About about) {
        this.aboutPage = about;
    }

    @GetMapping("/about")
    public String getAbout() {
        return "/about";
    }
}
